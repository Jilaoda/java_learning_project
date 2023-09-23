package com.blog.personalblog.controller;

import com.blog.personalblog.annotation.OperationLogSys;
import com.blog.personalblog.annotation.OperationType;
import com.blog.personalblog.bo.CategoryBO;
import com.blog.personalblog.common.PageRequestApi;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Category;
import com.blog.personalblog.service.CategoryService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-17 16:53:56
 * @description  基于Spring MVC框架的控制器，用于处理与用户相关的HTTP请求,
 *               并通过调用categoryService中的方法来完成相应的分页查询功能。
 */
@Api(tags = "分类管理")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * @details: 分页查询列表
     * @date: 2023/5/22
     * @Param: [pageRequest]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "分类列表")
    @PostMapping("list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<Category> categoryList = categoryService.getCategoryPage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(categoryList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * @details: 添加分类
     * @date: 2023/5/22
     * @Param: [category]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "添加分类")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加分类", operationType = OperationType.INSERT)
    public JsonResult<Object> categoryCreate(@RequestBody @Valid Category category) {
        int isStatus = categoryService.saveCategory(category);
        if (isStatus == 0) {
            return JsonResult.error("添加分类失败");
        }
        return JsonResult.success();
    }


    /**
     * @details: 修改分类
     * @date: 2023/5/22
     * @Param: [category]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "修改分类")
    @PostMapping("/update")
    public JsonResult<Object> categoryUpdate(@RequestBody @Valid Category category) {
        int isStatus = categoryService.updateCategory(category);
        if (isStatus == 0) {
            return JsonResult.error("修改分类失败");
        }
        return JsonResult.success();
    }

    /**
     * @details: 删除
     * @date: 2023/5/22
     * @Param: [id]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "删除分类")
    @PostMapping("/delete/{id}")
    public JsonResult<Object> categoryDelete(@PathVariable(value = "id") int id) {
        categoryService.deleteCategory(id);
        return JsonResult.success();
    }


    /**
     * @details: 搜索文章分类
     * @date: 2023/5/31
     * @Param: [bo]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "查询分类名称")
    @PostMapping("/getCategory")
    @OperationLogSys(desc = "查询分类名称", operationType = OperationType.SELECT)
    public JsonResult<Object> getCategoryByName(@RequestBody @Valid CategoryBO bo) {
        List<Category> categoriesByName = categoryService.getCategoriesByName(bo);
        return JsonResult.success(categoriesByName);
    }

}
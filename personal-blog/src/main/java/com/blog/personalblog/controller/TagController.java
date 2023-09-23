package com.blog.personalblog.controller;

import com.blog.personalblog.annotation.OperationLogSys;
import com.blog.personalblog.annotation.OperationType;
import com.blog.personalblog.bo.TagBO;
import com.blog.personalblog.common.PageRequestApi;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Tag;
import com.blog.personalblog.service.TagService;
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
 * @create 2023-05-22 18:32:41
 * @description 基于Spring MVC框架的控制器，用于处理与用户相关的HTTP请求,
 *              并通过调用categoryService中的方法来完成相应的标签管理。
 */
@Api(tags = "标签管理")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * @details: 分页查询列表
     * @date: 2023/5/22
     * @Param: [pageRequest]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "标签列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<Tag> tagList = tagService.getTagPage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(tagList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }

    /**
     * @details: 添加标签
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "添加标签")
    @PostMapping("/create")
    public JsonResult<Object> tagCreate(@RequestBody @Valid Tag tag) {
        int isStatus = tagService.saveTag(tag);
        if (isStatus == 0) {
            return JsonResult.error("添加公告失败");
        }
        return JsonResult.success();
    }

    /**
     * @details: 删除
     * @date: 2023/5/22
     * @Param: [id]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "删除标签")
    @DeleteMapping("/delete/{id}")
    public JsonResult<Object> tagDelete(@PathVariable(value = "id") int id) {
        tagService.deleteTag(id);
        return JsonResult.success();
    }


    /**
     * @details: 批量添加标签,最多添加10个
     * @date: 2023/5/22
     * @Param: [tags]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "批量添加标签")
    @PostMapping("/batchCreate")
    public JsonResult<Object> batchCreate(@RequestBody @Valid Tag tags) {
        try {
            boolean isStatus = tagService.batchAddTag(tags.getTagName());
            if (!isStatus) {
                return JsonResult.error("批量插入失败！");
            }
        }catch (Exception e) {
            return JsonResult.error(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * @details: 批量删除标签
     * @date: 2023/5/22
     * @Param: [ids]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "批量删除标签")
    @PostMapping("/batchDelete")
    public JsonResult<Object> batchDelete(@RequestBody @Valid String ids) {
        boolean isDelTag = tagService.batchDelTag(ids);
        if (!isDelTag) {
            return JsonResult.error("批量删除标签失败");
        }
        return JsonResult.success();
    }

    /**
     * @details: 修改标签
     * @date: 2023/5/22
     * @Param: [tag]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "修改标签")
    @PostMapping("/update")
    public JsonResult<Object> tagUpdate(@RequestBody @Valid Tag tag) {
        int isStatus = tagService.updateTag(tag);
        if (isStatus == 0) {
            return JsonResult.error("修改标签失败");
        }
        return JsonResult.success();
    }

    /**
     * 按条件查询文章标签
     * @param bo
     * @return
     */
    @ApiOperation(value = "查询文章标签")
    @PostMapping("/selectTag")
    @OperationLogSys(desc = "查询文章标签", operationType = OperationType.SELECT)
    public JsonResult<Object> getTagByTagName(@RequestBody @Valid TagBO bo) {
        List<Tag> tagsByTagName = tagService.getTagsByTagName(bo);
        return JsonResult.success(tagsByTagName);
    }



}

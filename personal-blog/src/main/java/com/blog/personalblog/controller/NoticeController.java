package com.blog.personalblog.controller;


import com.blog.personalblog.annotation.OperationLogSys;
import com.blog.personalblog.annotation.OperationType;
import com.blog.personalblog.common.PageRequestApi;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.config.page.PageResult;
import com.blog.personalblog.entity.Notice;
import com.blog.personalblog.service.NoticeService;
import com.blog.personalblog.util.JsonResult;
import com.blog.personalblog.util.PageUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-22 13:54:02
 * @description 公告管理接口
 */
@Api(tags = "公告管理")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    /**
     * @details: 分页查询列表
     * @date: 2023/5/22
     * @Param: [pageRequest]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "公告列表")
    @PostMapping("/list")
    public JsonResult<Object> listPage(@RequestBody @Valid PageRequestApi<PageRequest> pageRequest) {
        List<Notice> noticeList = noticeService.getNoticePage(pageRequest.getBody());
        PageInfo pageInfo = new PageInfo(noticeList);
        PageResult pageResult = PageUtil.getPageResult(pageRequest.getBody(), pageInfo);
        return JsonResult.success(pageResult);
    }


    /**
     * @details: 添加公告
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "添加公告")
    @PostMapping("/create")
    @OperationLogSys(desc = "添加公告", operationType = OperationType.INSERT)
    public JsonResult<Object> noticeCreate(@RequestBody @Valid Notice notice) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        notice.setCreateBy(username);
        int isStatus = noticeService.saveNotice(notice);
        if (isStatus == 0) {
            return JsonResult.error("添加公告失败");
        }
        return JsonResult.success();
    }

    /**
     * @details: 修改公告
     * @date: 2023/5/22
     * @Param: [notice]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "修改公告")
    @PostMapping("/update")
    public JsonResult<Object> noticeUpdate(@RequestBody @Valid Notice notice) {
        int isStatus = noticeService.updateNotice(notice);
        if (isStatus == 0) {
            return JsonResult.error("修改公告失败");
        }
        return JsonResult.success();
    }

    /**
     * @details: 删除
     * @date: 2023/5/22
     * @Param: [id]
     * @return: com.blog.personalblog.util.JsonResult<java.lang.Object>
     */
    @ApiOperation(value = "删除公告")
    @PostMapping("/delete")
    @OperationLogSys(desc = "删除公告", operationType = OperationType.DELETE)
    public JsonResult<Object> noticeDelete(@RequestParam(value = "id") int id) {
        noticeService.deleteNotice(id);
        return JsonResult.success();
    }

    @GetMapping("/info/{id}")
    @ApiOperation("根据id查询公告信息")
    @OperationLogSys(desc = "查询公告", operationType = OperationType.SELECT)
    public JsonResult<Object> getNotice(@PathVariable Integer id) {
        Notice notice = noticeService.getNoticeById(id);
        return JsonResult.success(notice);
    }
}

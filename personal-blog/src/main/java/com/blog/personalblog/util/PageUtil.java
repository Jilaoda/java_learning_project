package com.blog.personalblog.util;

import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.config.page.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @author liweiliang
 * @create 2023-05-17 17:00:57
 * @description 分页工具类
 */
public class PageUtil {

    /**
     * @details: 分页信息封装
     * @date: 2023/5/17
     * @Param: [pageRequest, pageInfo]
     * @return: com.blog.personalblog.config.page.PageResult
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize()); 
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setResult(pageInfo.getList());
        return pageResult;
    }

}
package com.blog.personalblog.config.page;

import lombok.Data;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-17 16:47:18
 * @description 分类返回页
 */
@Data
public class PageResult {

    //当前页码
    private int pageNum;
    ///每页的数据条数
    private int pageSize;
    //总记录数
    private long totalSize;
    //总页数
    private int totalPages;
    //数据
    private List<?> result;

}
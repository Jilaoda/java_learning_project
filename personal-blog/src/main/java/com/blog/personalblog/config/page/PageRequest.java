package com.blog.personalblog.config.page;

import lombok.Data;

/**
 * @author liweiliang
 * @create 2023-05-17 16:44:41
 * @description 分页请求
 */
@Data
public class PageRequest {
    //页码
    private int pageNum;
    //每页的数据条数
    private int pageSize;
}
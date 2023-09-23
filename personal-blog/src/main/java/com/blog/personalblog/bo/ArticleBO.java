package com.blog.personalblog.bo;

import lombok.Data;

/**
 * @author liweiliang
 * @create 2023-05-27 11:13:54
 * @description 取代了PageRequest.java的分页类,同时将三种查询逻辑都放置在Bo包的类中，用于多个逻辑的封装
 */
@Data
public class ArticleBO {

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 发布，默认0, 0-发布, 1-草稿
     */
    private Integer artStatus;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页的数据条数
     */
    private int pageSize;
}

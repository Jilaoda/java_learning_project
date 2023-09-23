package com.blog.personalblog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liweiliang
 * @create 2023-05-17 16:54:14
 * @description 博客分类
 */
@Data
public class Category {
    //主键
    private Integer categoryId;
    //分类名
    private String categoryName;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
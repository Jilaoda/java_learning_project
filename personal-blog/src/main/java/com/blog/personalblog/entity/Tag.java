package com.blog.personalblog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liweiliang
 * @create 2023-05-22 17:43:01
 * @description 标签类
 */
@Data
public class Tag {
    //主键id
    private Integer id;
    //标签名称
    private String tagName;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
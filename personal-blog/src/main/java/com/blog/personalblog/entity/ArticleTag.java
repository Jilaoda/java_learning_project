package com.blog.personalblog.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author liweiliang
 * @create 2023-05-28 17:30:20
 * @description 文章标签实体类
 */
@Data
@Builder
public class ArticleTag {

    //id主键
    private Integer id;
    //文章id
    private Integer articleId;
    //标签id
    private Integer tagId;

}
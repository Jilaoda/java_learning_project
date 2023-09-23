package com.blog.personalblog.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liweiliang
 * @create 2023-05-31 23:02:32
 * @description
 */
@Getter
@AllArgsConstructor
public enum ArticleArtStatusEnum {
    /**
     * 发布
     */
    PUBLISH(1, "发布"),
    /**
     * 仅我可见
     */
    ONLYME(2, "仅我可见"),
    /**
     * 草稿
     */
    DRAFT(3, "草稿");

    /**
     * 状态
     */
    private final Integer status;

    /**
     * 描述
     */
    private final String desc;
}

package com.blog.personalblog.config.mail;

import lombok.Builder;
import lombok.Data;

/**
 * @author liweiliang
 * @create 2023-05-28 18:00:42
 * @description
 */
@Builder
@Data
public class MailInfo {
    /**
     * 接收的邮箱
     */
    private String receiveMail;

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件内容
     */
    private String content;

}
package com.blog.personalblog.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liweiliang
 * @create 2023-05-09 21:40:16
 * @description User实体类
 */
@Data   //Lombok的注解：自动生成get、set方法、构造器、构造方法、toString方法
public class User {
    //主键id
    private Integer id;
    //用户名
    private String userName;
    //密码
    private String passWord;
    //邮箱
    private String email;
    /**
     * 上次登录时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;
    //手机号
    private String phone;
    //昵称
    private String nickname;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}

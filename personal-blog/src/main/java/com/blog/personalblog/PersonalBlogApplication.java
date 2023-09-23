package com.blog.personalblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //这个注解告诉 Spring Boot 这是一个 Spring 应用程序
//扫描 com.blog.personalblog.mapper 包下的所有 Mapper 接口，并把它们转化为 Spring 的 Bean 对象
@MapperScan("com.blog.personalblog.mapper")
public class PersonalBlogApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(PersonalBlogApplication.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

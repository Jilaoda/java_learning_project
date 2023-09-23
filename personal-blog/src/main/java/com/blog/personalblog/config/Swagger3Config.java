package com.blog.personalblog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author liweiliang
 * @create 2023-05-16 22:37:43
 * @description Swagger接口文档的配置文件
 */
@Configuration
@EnableOpenApi
public class Swagger3Config {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).enable(true)
                .select()
                //添加swagger接口提取范围,修改成指向你的controller包
                .apis(RequestHandlerSelectors.basePackage("com.blog.personalblog.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("个人博客系统接口文档")
                .description("个人博客系统")
                .contact(new Contact("liweiliang93", "https://github.com/liweiliang93/personal-blog", "作者Email"))
                .version("1.0")
                .build();
    }

}
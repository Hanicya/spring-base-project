package com.cbz.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    // 控制是否启用swagger文档 生产环境的时候要关掉
    @Value("${application.swagger.enable}")
    private Boolean enable;

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(getApiInfo())
                .select()
                 // 这里指定你自己的Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.cbz.controller"))
                // 直接扫描所有的注解
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api信息
     */
    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("城把子BaseProject")
                .description("基础项目，用于快速开发web应用")
                .contact(new Contact("黄奕城", "", "837425169@qq.com"))
                .version("1.0")
                .build();
    }
}

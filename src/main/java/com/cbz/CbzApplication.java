package com.cbz;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/8
 */
@Slf4j
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages = "com.cbz.mapper")
public class CbzApplication {
    public static void main(String[] args) {
        SpringApplication.run(CbzApplication.class, args);
        log.info("<==项目启动完成");
    }
}

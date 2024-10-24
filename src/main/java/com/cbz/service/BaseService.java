package com.cbz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbz.mapper.SysUserMapper;
import com.cbz.model.entity.sys.SysUser;
import com.cbz.model.resp.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/21
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class BaseService extends ServiceImpl<SysUserMapper, SysUser> {


    public void async() {
        // 生成订单
        System.out.println("树枝666");

        // 清除购物车异步执行
        CompletableFuture.runAsync(() -> {
            try {
                for (int i=0;i<5;i++){
                    Thread.sleep(1000);
                    System.out.println(i);
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // 记录日志
        System.out.println("Order created and cart clearing initiated.");
    }


    @Cacheable(value="student", key="'yicheng'")
    public Student getCache() {
        log.info("访问获取数据");
        return new Student(1,"黄奕城");
    }

}


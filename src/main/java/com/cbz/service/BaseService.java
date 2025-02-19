package com.cbz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cbz.mapper.OrderMapper;
import com.cbz.mapper.SysUserMapper;
import com.cbz.model.entity.shop.Order;
import com.cbz.model.entity.sys.SysUser;
import com.cbz.model.resp.Student;
import com.cbz.model.resp.UserBuyRecordsResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author HuangYiCheng
 * @since 2024/8/21
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class BaseService extends ServiceImpl<SysUserMapper, SysUser> {

    @Resource
    private OrderMapper orderMapper;


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

    public UserBuyRecordsResp getDynamicData() {
        SysUser sysUser = baseMapper.selectOne(null);
        Order order = orderMapper.selectOne(null);
        UserBuyRecordsResp resp = new UserBuyRecordsResp();
        resp.setUsername(sysUser.getUsername());
        resp.setOrderNo(order.getOrderNo());
        resp.setThingName(order.getThingName());
        return resp;
    }


    public void mybatisTest() {
        SysUser sysUser = baseMapper.selectOne(new LambdaQueryWrapper<SysUser>().last("limit 1"));

        baseMapper.update(sysUser,new LambdaUpdateWrapper<SysUser>()
                        .eq(SysUser::getId,sysUser.getId())
                .set(SysUser::getUpdateTime,null));
    }

    @Transactional(rollbackFor = Exception.class)
    public void DynamicDataInTrans() {
        SysUser sysUser = baseMapper.selectOne(null);
        Order order = orderMapper.selectOne(null);
        baseMapper.updateById(sysUser);
        order.setThingName("新的");
        orderMapper.updateById(order);
    }
}


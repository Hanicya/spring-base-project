package com.cbz.controller;

import com.cbz.exception.BizException;
import com.cbz.model.entity.sys.SysUser;
import com.cbz.model.resp.Student;
import com.cbz.model.resp.UserBuyRecordsResp;
import com.cbz.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author HuangYiCheng
 * @since 2024/8/8
 */
@Slf4j
@Api(tags = "Base接口")
@RestController
@RequestMapping("/test")
public class BaseController {

    @Resource
    private BaseService service;

    @ApiOperation("直接返回字符串")
    @GetMapping("/getStr")
    public String getStr() {
        return "hello";
    }

    @ApiOperation("全局异常处理")
    @GetMapping("/globalException")
    public void globalException() {
        System.out.println("报错辣！");
        throw new BizException();
    }

    @ApiOperation("统一结果返回")
    @GetMapping("/unifiedResult")
    public Student unifiedResult() {
        return new Student(1,"黄奕城");
    }

    @ApiOperation("持久层框架接入")
    @GetMapping("/getDataByMybatisPlus")
    public List<SysUser> getDataByMybatisPlus(){
        return service.list();
    }

    @ApiOperation("异步执行")
    @GetMapping("/async")
    public void async(){
        service.async();
    }


    @ApiOperation("本地缓存")
    @GetMapping("/cache")
    public Student getCache(){
        return service.getCache();
    }

    @ApiOperation("动态数据源")
    @GetMapping("/getDynamicData")
    public UserBuyRecordsResp getDynamicData(){
        return service.getDynamicData();
    }

    @ApiOperation("动态数据源-事务")
    @GetMapping("/DynamicDataInTrans")
    public void DynamicDataInTrans(){
        service.DynamicDataInTrans();
    }

    @ApiOperation("mybatis-实验")
    @GetMapping("/mybatisTest")
    public void mybatisTest(){
        service.mybatisTest();
    }

    @ApiOperation("日志")
    @GetMapping("/log")
    public void log() {
        log.info("info日志");
        log.error("error日志");
    }





}

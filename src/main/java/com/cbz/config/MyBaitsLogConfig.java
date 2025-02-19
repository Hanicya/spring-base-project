package com.cbz.config;

import org.apache.ibatis.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HuangYiCheng
 * @since 2024/12/4
 * 自定义mybatis日志输出
 */
public class MyBaitsLogConfig implements Log {

    private final Logger log;

    public MyBaitsLogConfig(String clazz) {
        log = LoggerFactory.getLogger(clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return true; // 默认开启 Debug
    }

    @Override
    public boolean isTraceEnabled() {
        return true; // 默认开启 Trace
    }

    @Override
    public void error(String s, Throwable e) {
        log.info(s,e);
    }

    @Override
    public void error(String s) {
        log.info(s);
    }

    @Override
    public void debug(String s) {
        if(s.contains("SELECT")){
            log.info("======>>>查询语句===>>>");
        }else if(s.contains("UPDATE")){
            log.info("======>>>更新语句===>>>");
        }else if(s.contains("INSERT")){
            log.info("======>>>新增语句===>>>");
        }else if(s.contains("DELETE")){
            log.info("======>>>删除语句===>>>");
        }
        log.info(s);  //SQL 获取参数输出至 info
    }

    @Override
    public void trace(String s) {
        log.trace(s); //SQL 信息输出至 info
    }

    @Override
    public void warn(String s) {
        log.warn(s);
    }
}

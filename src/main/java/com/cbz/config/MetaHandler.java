package com.cbz.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * @author HuangYiCheng
 * @since 2024/12/14
 */
@Slf4j
@Component
public class MetaHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

    }
    /**
     * 新增数据执行
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            Timestamp time = new Timestamp(System.currentTimeMillis());
            if (metaObject.hasSetter("updateTime")) {
                log.info("自动插入 updateTime");
                this.setFieldValByName("updateTime", time, metaObject);
            }
        } catch (Exception e) {
            log.error("自动注入失败:{}", e.getMessage());
        }
    }
}

package com.cbz.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * spring task 中，任务调度默认是使用单线程的，如果要提升调度性能，需要额外配置线程池
 */
@Component
public class BaseTask {

//    @Value("${application.taskInterval.autoPraise}")
//    private long fixedRate;  // 从配置文件中获取


    /**
     * 自动好评
     */
    @Scheduled(fixedRateString = "${application.taskInterval.autoPraise}")
    public void autoPraise(){
        System.out.println("自动好评业务执行");
    }

}

package com.cbz.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/13
 * 定义一个切面
 */
@Aspect
@Component
public class MyAspect {

    // 一般使用环绕通知
    @Around("execution(* com.cbz.controller.BaseController.*(..))")   //第一个* 表示任何返回值   第二个* 表示任何方法
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {    // pjp是一个 包含拦截方法信息的对象
        System.out.println("time aspect start");
        //参数数组
        Object[] args = pjp.getArgs();
        for (Object arg:args){
            System.out.println("arg is :" +arg);
        }
        long start = System.currentTimeMillis();
        // 调用被拦截的方法
        Object object = pjp.proceed();
        System.out.println("time aspect 耗时："+(System.currentTimeMillis() - start));
        System.out.println("time aspect end");
        return object;
    }
}

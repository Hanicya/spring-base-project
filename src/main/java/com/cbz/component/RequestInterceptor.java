package com.cbz.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HuangYiCheng
 * @since 2024/8/8
 * 拦截器
 */
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    // 隔离变量，不是归属于类的
    private static final ThreadLocal<Long> REQUEST_THREAD = new NamedThreadLocal<>("request");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        long time = System.currentTimeMillis();
//        System.out.println("开始时间："+ time + "hashCode: " + REQUEST_THREAD.hashCode());
        System.out.println("拦截器preHandle");
        REQUEST_THREAD.set(time);
        log.info("请求路径：{}",request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
        // 如果报全局异常被切面捕获，这里是不会成功执行的
        System.out.println("拦截器postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
        long endTime = System.currentTimeMillis();
        Long startTime = REQUEST_THREAD.get();
//        System.out.println("结束时间："+ endTime + "hashCode: " + REQUEST_THREAD.hashCode());
        log.info("请求耗时：{}",endTime - startTime);
        System.out.println("拦截器afterCompletion");
    }


}

package com.cbz.component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/13
 */
@Component
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Filter init...");
    }


    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter...");
        //对request,response进行预处理
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {
        System.out.println("filter destroy...");
    }
}

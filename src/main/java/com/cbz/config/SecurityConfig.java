package com.cbz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/15
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    /**
     * web安全配置
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                // 开放knife4j资源
                .antMatchers("/doc.html")
                .antMatchers("/v2/**")
                .antMatchers("/swagger-resources/**")
                // 开放websocket资源
                .antMatchers("/ws/webSocket")
                // 测试接口
                .antMatchers("/test/**");

    }

    /**
     * http安全配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable() // 启用跨域请求限制和禁用跨站请求伪造安全检验
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 会话管理策略设置为无状态
                .and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()               // 允许跨域预检请求
                .anyRequest().authenticated(); // 其他所有请求需要身份认证
    }
    /**
     * 使用SpringSecurity提供的密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 使用鉴权管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

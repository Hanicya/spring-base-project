package com.cbz.security.config;

import com.cbz.security.annotation.AnonymousAccess;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author HuangYiCheng
 * @since  2024/8/15
 * 采用基于注解配置风格对web安全策略进行配置，（比较一下继承 web安全配置器适配器WebSecurityConfigurerAdapter的OOP风格）
 */
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {


    private final ApplicationContext applicationContext;
    private final CorsFilter corsFilter;


    /**
     * 安全链配置
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // 搜寻匿名标记
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = applicationContext.getBean(RequestMappingHandlerMapping.class).getHandlerMethods();
        Set<String> anonymousUrls = new HashSet<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> infoEntry : handlerMethodMap.entrySet()) {
            HandlerMethod handlerMethod = infoEntry.getValue();
            AnonymousAccess anonymousAccess = handlerMethod.getMethodAnnotation(AnonymousAccess.class);
            if (null != anonymousAccess) {
                assert infoEntry.getKey().getPatternsCondition() != null;
                anonymousUrls.addAll(infoEntry.getKey().getPatternsCondition().getPatterns());
            }
        }
        return httpSecurity
                // 禁用跨站请求伪造安全检验
                .csrf().disable()
                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//                 授权异常处理器
                .exceptionHandling()
//                .authenticationEntryPoint(authenticationErrorHandler)
//                .accessDeniedHandler(jwtAccessDeniedHandler)
                // 防止iframe造成跨域
                .and()
                .headers()
                .frameOptions()
                .disable()
                // 不创建会话
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 静态资源
                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webSocket/**"
                ).permitAll()
                // 开放knife4j资源
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                // druid连接池
                .antMatchers("/druid/**").permitAll()
                // 文件
                .antMatchers("/file/**").permitAll()
                // 测试
                .antMatchers("/test/**").permitAll()
                // 自定义匿名访问所有url放行 ： 允许匿名和带权限以及登录用户访问
                .antMatchers(anonymousUrls.toArray(new String[0])).permitAll()
                // 所有请求都需要认证
                .anyRequest().authenticated()
//                .and().apply(securityConfigurerAdapter())
                .and()
                .build();
    }
    /**
     * 使用SpringSecurity提供的密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}

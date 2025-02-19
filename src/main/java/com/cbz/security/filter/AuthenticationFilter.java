package com.cbz.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author HuangYiCheng
 * @since 2024/8/8
 * 认证过滤器
 */
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter  {

    @Value("${application.jwt.tokenPrefix}")
    private String tokenPrefix;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (Objects.nonNull(authHeader) && authHeader.startsWith(this.tokenPrefix)) {
//            String authToken = authHeader.substring(this.tokenPrefix.length());
//            // 解析token得到用户名
//            String username = jwtTokenUtil.getUserNameFromToken(authToken);
//            log.info("checking username:{}", username);
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    LOGGER.info("authenticated user:{}", username);
//                    // 需要放置到去安全上下文中，不然是不会通过验证的
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//        chain.doFilter(request, response);
    }
}

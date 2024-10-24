package com.cbz.auth;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/15
 * 登录检验过滤器
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter{


//    /**
//     * 认证之前预处理
//     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        String body = HttpUtils.getBody(request);
//        JSONObject jsonObject = JSONUtil.parseObj(body);
//        String username = jsonObject.getStr("username");
//        String password = jsonObject.getStr("password");
//        if (username == null) {
//            username = "";
//        }
//        if (password == null) {
//            password = "";
//        }
//        username = username.trim();
//        password = RSAUtils.privateDecrypt(password);
//        JwtAuthenticateToken authRequest = SecurityUtils.login(request, username, password, this.getAuthenticationManager());
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        SecurityContextHolder.clearContext();
//        ResultStatus.Auth sessionError = ResultStatus.Common.Auth.PARAMS_ERROR;
//        HttpUtils.write(response, new ResponseResult(null, sessionError.getRetcode(), sessionError.getMsg(), null, null));
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        //外网权限验证
//        Boolean outerNet = SecurityUtils.checkoutOuterNet(request.getRequestURL().toString());
//        if(!outerNet){
//            HttpUtils.write(response, new ResponseResult(null, 40404, "很抱歉，您没有外网访问权限，请联系管理员开启权限后再登录", null, null));
//        }
//        // 存储登录认证信息到上下文
//        SecurityContextHolder.getContext().setAuthentication(authResult);
//        // 记住我服务
//        getRememberMeServices().loginSuccess(request, response, authResult);
//        // 触发事件监听器
//        if (this.eventPublisher != null) {
//            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
//        }
//        // 生成并返回token给客户端，后续访问携带此token
//        JwtAuthenticateToken token = new JwtAuthenticateToken(null, null, JwtTokenUtils.generateToken(authResult));
//        HttpUtils.write(response, ResponseResult.success(token));
//    }
}

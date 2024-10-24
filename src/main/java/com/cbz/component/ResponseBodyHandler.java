package com.cbz.component;


import com.cbz.response.NotWrapResponse;
import com.cbz.response.R;
import com.cbz.response.ResultStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一结果封装器，通过实现ResponseBodyAdvice接口方式（HttpServletResponseWrapper这个也可以实现，但是代码量更多，接近底层）
 */
@ControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     *
     * @param returnType 方法的返回类型
     * @param converterType  Java 对象转换为 HTTP 消息体
     * @return 是否提供包装
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("是否支持");
        return !returnType.getParameterType().isAssignableFrom(R.class)
                && !returnType.getParameterType().isAssignableFrom(ResponseEntity.class)
                && !returnType.hasMethodAnnotation(NotWrapResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            try {
                return objectMapper.writeValueAsString(body);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("写之前！");
        return new R<>(body, ResultStatus.Common.SUCCESS.getCode(), ResultStatus.Common.SUCCESS.getMsg());
    }
}

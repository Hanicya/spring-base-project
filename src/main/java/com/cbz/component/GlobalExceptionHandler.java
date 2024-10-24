package com.cbz.component;

import com.cbz.exception.BizException;
import com.cbz.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * 全局异常处理器
 * 该处理将所有异常统一处理，对外提供统一的错误码和返回的格式
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 业务相关异常捕获拦截
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity<?> exceptionHandler(BizException e) {
        System.out.println("异常处理！！！！！");
        HttpStatus status = HttpStatus.OK;
        R<?> result = new R<>(null, e.getStatus().getCode(), e.getStatus().getMsg());
        return ResponseEntity.status(status).body(result);
    }


}

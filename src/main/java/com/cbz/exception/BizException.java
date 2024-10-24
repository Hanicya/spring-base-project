package com.cbz.exception;

import com.cbz.response.ResultStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException{

    private final ResultStatus status;

    /**
     * 默认构造错误的状态
     */
    public BizException() {
        this.status = ResultStatus.Common.ERROR_UNKNOWN;
    }

}

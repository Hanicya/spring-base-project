package com.cbz.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 返回状态接口
 */
public interface ResultStatus {

    /**
     * 返回码
     */
    int getCode();

    /**
     * 返回信息
     */
    String getMsg();


    /**
     * 成员内部类，通用的错误码
     */
    @Getter
    @AllArgsConstructor
    enum Common implements ResultStatus {
        SUCCESS(0, "成功"),
        ERROR_UNKNOWN(-1, "未知错误");
        private final int code;
        private final String msg;
    }

}

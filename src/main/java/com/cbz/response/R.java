package com.cbz.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一结果返回类
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    /**
     * 请求结果对象
     **/
    private T data;

    /**
     * 请求结果的状态码
     **/
    private int code;

    /**
     * 错误消息
     **/
    private String msg;

}

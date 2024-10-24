package com.cbz.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/28
 */
@Getter
@AllArgsConstructor
public enum Degree {
    BACHELOR(1, "学士"),
    MASTER(2, "硕士"),
    DOCTOR(3, "博士");

    @EnumValue
    private final Integer code;
    @JsonValue
    private final String desc;

}

package com.cbz.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author HuangYiCheng
 * @since 2024/8/21
 */
@Data
public abstract class BaseEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Integer id;

    @JsonIgnore
    @TableLogic
    private Integer deleted;

}
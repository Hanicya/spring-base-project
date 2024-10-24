package com.cbz.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/21
 */
@Data
public abstract class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @JsonIgnore
    @TableLogic
    private Integer deleted;

}
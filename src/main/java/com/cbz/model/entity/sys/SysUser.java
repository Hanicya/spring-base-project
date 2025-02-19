package com.cbz.model.entity.sys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cbz.model.entity.BaseEntity;
import com.cbz.model.enums.Degree;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author HuangYiCheng
 * @since 2024/8/21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {

    @ApiModelProperty("用户名字")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("学位")
    private Degree degree;
    @ApiModelProperty("是否成年")
    private Integer isAdult;

    @TableField(fill= FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;



}

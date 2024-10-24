package com.cbz.model.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cbz.model.entity.BaseEntity;
import com.cbz.model.enums.Degree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class SysUser extends BaseEntity {

    private String username;
    private String password;

    private Degree degree;

}

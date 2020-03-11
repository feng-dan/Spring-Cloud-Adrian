package com.adrian.common.entity.po.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserRole
 * @Description
 * @Date 2020-01-07 17:24
 */
@Data
@TableName("t_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = -3166012934498268403L;

    @TableField(value = "USER_ID")
    private Long userId;

    @TableField(value = "ROLE_ID")
    private Long roleId;

}

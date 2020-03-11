package com.adrian.common.entity.po.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName Menu
 * @Description ${DESCRIPTION}
 * @Date 2020-01-03 18:23
 */

@Data
@TableName(value = "t_menu")
public class Menu implements Serializable {

    /**
     * 菜单/按钮ID
     */
    @TableId(value = "MENU_ID", type = IdType.AUTO)
    private Long menuId;

    /**
     * 上级菜单ID
     */
    @TableField(value = "PARENT_ID")
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    @TableField(value = "MENU_NAME")
    private String menuName;

    /**
     * 对应路由path
     */
    @TableField(value = "PATH")
    private String path;

    /**
     * 对应路由组件component
     */
    @TableField(value = "COMPONENT")
    private String component;

    /**
     * 权限标识
     */
    @TableField(value = "PERMS")
    private String perms;

    /**
     * 图标
     */
    @TableField(value = "ICON")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @TableField(value = "TYPE")
    private String type;

    /**
     * 排序
     */
    @TableField(value = "ORDER_NUM")
    private Double orderNum;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "MODIFY_TIME")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_MENU_ID = "MENU_ID";

    public static final String COL_PARENT_ID = "PARENT_ID";

    public static final String COL_MENU_NAME = "MENU_NAME";

    public static final String COL_PATH = "PATH";

    public static final String COL_COMPONENT = "COMPONENT";

    public static final String COL_PERMS = "PERMS";

    public static final String COL_ICON = "ICON";

    public static final String COL_TYPE = "TYPE";

    public static final String COL_ORDER_NUM = "ORDER_NUM";

    public static final String COL_CREATE_TIME = "CREATE_TIME";

    public static final String COL_MODIFY_TIME = "MODIFY_TIME";
}
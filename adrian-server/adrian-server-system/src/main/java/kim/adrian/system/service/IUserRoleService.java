package kim.adrian.system.service;

import com.adrian.common.entity.po.system.UserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName IUserRoleService
 * @Description
 * @Date 2020-01-07 17:25
 */
public interface IUserRoleService {

    /**
     * save
     *
     * @param userRole userRole
     * @return boolean
     */
    boolean save(UserRole userRole);

    /**
     * remove
     *
     * @param queryWrapper
     */
    void remove(LambdaQueryWrapper<UserRole> queryWrapper);

    /**
     * deleteUserRolesByRoleId
     *
     * @param roleIds
     */
    void deleteUserRolesByRoleId(String[] roleIds);

    /**
     * deleteUserRolesByUserId
     *
     * @param userIds
     */
    void deleteUserRolesByUserId(String[] userIds);
}

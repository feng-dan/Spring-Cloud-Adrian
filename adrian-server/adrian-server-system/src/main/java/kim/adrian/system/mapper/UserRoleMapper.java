package kim.adrian.system.mapper;

import com.adrian.common.entity.po.system.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserRoleMapper
 * @Description
 * @Date 2020-01-08 17:01
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户 ID
     * @return boolean
     */
    Boolean deleteByUserId(@Param("userId") Long userId);

    /**
     * 根据角色Id删除该角色的用户关系
     *
     * @param roleId 角色 ID
     * @return boolean
     */
    Boolean deleteByRoleId(@Param("roleId") Long roleId);
}

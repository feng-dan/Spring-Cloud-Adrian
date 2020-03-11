package kim.adrian.system.mapper;

import com.adrian.common.entity.po.system.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserMapper
 * @Description
 * @Date 2020-01-07 14:35
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    /**
     * 查找用户详细信息
     *
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return IPage<SystemUser>
     */
    IPage<SystemUser> findUserDetailPage(Page page, @Param("user") SystemUser user);

    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(SystemUser user);

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(SystemUser user);

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUsers(String[] userIds);
}

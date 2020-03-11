package kim.adrian.system.service;

import com.adrian.common.entity.QueryRequest;
import com.adrian.common.entity.po.system.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName IUserService
 * @Description
 * @Date 2020-01-07 15:18
 */
public interface IUserService extends IService<SystemUser> {

    /**
     * 查找用户详细信息
     *
     * @param request request
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request);

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

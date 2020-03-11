package kim.adrian.system.service.impl;

import com.adrian.common.entity.QueryRequest;
import com.adrian.common.entity.po.system.SystemUser;
import com.adrian.common.entity.po.system.UserRole;
import com.adrian.common.exception.ServiceException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.adrian.system.exception.AdrianServerSystemErrorType;
import kim.adrian.system.mapper.UserMapper;
import kim.adrian.system.service.IUserRoleService;
import kim.adrian.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserServiceImpl Cannot access com.adrian.common.entity.po.system.SystemUser
 * @Description
 * @Date 2020-01-07 15:18
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, SystemUser> implements IUserService {

    private final PasswordEncoder passwordEncoder;

    private final IUserRoleService userRoleService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, IUserRoleService userRoleService) {
        this.passwordEncoder = passwordEncoder;
        this.userRoleService = userRoleService;
    }

    @Override
    public IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request) {
        Page<SystemUser> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.baseMapper.findUserDetailPage(page, user);
    }

    /**
     * 新增用户
     *
     * @param user user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createUser(SystemUser user) {
        try {
            // 创建用户
            user.setCreateTime(new Date());
            user.setAvatar(SystemUser.DEFAULT_AVATAR);
            user.setPassword(passwordEncoder.encode(SystemUser.DEFAULT_PASSWORD));
            save(user);
            // 保存用户角色
            String[] roles = user.getRoleId().split(StringPool.COMMA);
            setUserRoles(user, roles);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(AdrianServerSystemErrorType.FAILED_TO_ADD_USER);
        }
    }

    /**
     * 修改用户
     *
     * @param user user
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(SystemUser user) {
        try {
            // 更新用户
            user.setPassword(null);
            user.setUsername(null);
            user.setCreateTime(null);
            user.setModifyTime(new Date());
            updateById(user);

            userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, user.getUserId()));
            String[] roles = user.getRoleId().split(StringPool.COMMA);
            setUserRoles(user, roles);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(AdrianServerSystemErrorType.MODIFY_USER_FAILED);
        }

    }

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteUsers(String[] userIds) {
        try {
            List<String> list = Arrays.asList(userIds);
            removeByIds(list);
            // 删除用户角色
            this.userRoleService.deleteUserRolesByUserId(userIds);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServiceException(AdrianServerSystemErrorType.FAILED_TO_DELETE_USER);
        }

    }

    private void setUserRoles(SystemUser user, String[] roles) {
        Arrays.stream(roles).forEach(roleId -> {
            UserRole ur = new UserRole();
            ur.setUserId(user.getUserId());
            ur.setRoleId(Long.valueOf(roleId));
            userRoleService.save(ur);
        });
    }
}

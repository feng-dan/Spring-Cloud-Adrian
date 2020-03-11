package kim.adrian.system.service.impl;

import com.adrian.common.entity.po.system.UserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import kim.adrian.system.mapper.UserRoleMapper;
import kim.adrian.system.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserRoleServiceImpl
 * @Description
 * @Date 2020-01-07 17:26
 */
@Slf4j
@Service("userRoleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public boolean save(UserRole entity) {
        return super.save(entity);
    }

    @Override
    public void remove(LambdaQueryWrapper<UserRole> queryWrapper) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRolesByRoleId(String[] roleIds) {
        Arrays.stream(roleIds).forEach(id -> baseMapper.deleteByRoleId(Long.valueOf(id)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRolesByUserId(String[] userIds) {
        Arrays.stream(userIds).forEach(id -> baseMapper.deleteByUserId(Long.valueOf(id)));
    }
}

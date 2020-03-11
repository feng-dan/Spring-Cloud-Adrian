package kim.adrian.auth.manager;

import com.adrian.common.entity.po.system.*;
import com.adrian.common.entity.po.system.SystemUser;
import kim.adrian.auth.mapper.MenuMapper;
import kim.adrian.auth.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserManager
 * @Description 用于统一定义和用户相关的业务方法
 * @Date 2020-01-06 16:45
 */
@Service
public class UserManager {
    private final UserMapper userMapper;
    private final MenuMapper menuMapper;

    public UserManager(UserMapper userMapper, MenuMapper menuMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
    }

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}

package kim.adrian.auth.service;

import com.adrian.common.entity.AdrianAuthUser;
import com.adrian.common.entity.po.system.SystemUser;
import kim.adrian.auth.manager.UserManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianUserDetailService
 * @Description
 * @Date 2019-12-14 22:04
 */
@Service
public class AdrianUserDetailsService implements UserDetailsService {

    private final UserManager userManager;

    public AdrianUserDetailsService(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String userPermissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus())) {
                notLocked = true;
            }
            AdrianAuthUser adrianAuthUser = new AdrianAuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(userPermissions));
            BeanUtils.copyProperties(systemUser, adrianAuthUser);
            return adrianAuthUser;
        } else {
            throw new UsernameNotFoundException("");
        }
    }
}

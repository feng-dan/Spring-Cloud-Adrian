package kim.adrian.auth.mapper;

import org.apache.ibatis.annotations.Param;

import com.adrian.common.entity.po.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName SystemUserMapper
 * @Description ${DESCRIPTION}
 * @Date 2020-01-03 18:18
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    /**
     * findByName
     *
     * @param username
     * @return
     */
    SystemUser findByName(@Param("username") String username);

}
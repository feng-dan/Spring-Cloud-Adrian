package kim.adrian.auth.mapper;

import com.adrian.common.entity.po.system.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName MenuMapper
 * @Description ${DESCRIPTION}
 * @Date 2020-01-03 18:23
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * findUserPermissions
     *
     * @param username
     * @return
     */
    List<Menu> findUserPermissions(String username);
}
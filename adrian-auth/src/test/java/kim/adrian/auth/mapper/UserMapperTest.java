package kim.adrian.auth.mapper;

import com.adrian.common.entity.po.system.SystemUser;
import kim.adrian.auth.AdrianAuthApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName UserMapperTest
 * @Description
 * @Date 2020-01-07 10:14
 */
public class UserMapperTest extends AdrianAuthApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByName() {
        SystemUser fengdan = userMapper.findByName("fengdan");
    }
}
package kim.adrian.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAuthProperties
 * @Description 参数配置化-认证相关配置
 * @Date 2019-12-31 14:14
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:adrian-auth.properties"})
@ConfigurationProperties(prefix = "adrian.auth")
public class AdrianAuthProperties {

    private AdrianClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     * 免认证路径
     */
    private String anonUrl;

    /**
     * 验证码配置类
     */
    private AdrianValidateCodeProperties code = new AdrianValidateCodeProperties();
}

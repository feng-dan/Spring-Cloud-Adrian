package kim.adrian.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerSystemProperties
 * @Description
 * @Date 2020-01-11 15:18
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:adrian-server-system.properties"})
@ConfigurationProperties(prefix = "adrian.server.system")
public class AdrianServerSystemProperties {
    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;
    private AdrianSwaggerProperties swagger = new AdrianSwaggerProperties();
}

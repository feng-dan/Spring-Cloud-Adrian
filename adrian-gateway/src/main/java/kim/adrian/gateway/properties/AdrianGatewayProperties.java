package kim.adrian.gateway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianGatewayProperties
 * @Description
 * @Date 2020-01-25 13:36
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:adrian-gateway.properties"})
@ConfigurationProperties(prefix = "adrian.gateway")
public class AdrianGatewayProperties {
    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}

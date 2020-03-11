package kim.adrian.auth.properties;

import lombok.Data;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAuthorizationServerConfigure
 * @Description 参数配置化-认证相关配置
 * @Date 2019-12-31 14:10
 */
@Data
public class AdrianClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}

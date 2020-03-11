package kim.adrian.gateway.configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianGatewaySecurityConfigure
 * @Description
 * @Date 2019-12-20 18:17
 */
@EnableWebSecurity
public class AdrianGatewaySecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

}

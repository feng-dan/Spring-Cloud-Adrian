package kim.adrian.register.configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianRegisterWebSecurityConfigure
 * @Description 安全配置
 * @Date 2019-12-13 23:10
 */
@EnableWebSecurity
public class AdrianRegisterWebSecurityConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**")
                .and().authorizeRequests().antMatchers("/actuator/**").permitAll();
        super.configure(http);
    }
}

package kim.adrian.test.configure;

import com.adrian.common.handler.AdrianAccessDeniedHandler;
import com.adrian.common.handler.AdrianAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerTestResourceServerConfigure
 * @Description
 * @Date 2019-12-30 18:48
 */
@Configuration
@EnableResourceServer
public class AdrianServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private AdrianAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AdrianAuthExceptionEntryPoint exceptionEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}

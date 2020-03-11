package kim.adrian.auth.configure;

import com.adrian.common.handler.AdrianAccessDeniedHandler;
import com.adrian.common.handler.AdrianAuthExceptionEntryPoint;
import kim.adrian.auth.properties.AdrianAuthProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianResourceServerConfigure
 * @Description 资源服务器的配置类
 * @Date 2019-12-14 22:34
 */
@Configuration
@EnableResourceServer
public class AdrianResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private AdrianAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AdrianAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private AdrianAuthProperties properties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}

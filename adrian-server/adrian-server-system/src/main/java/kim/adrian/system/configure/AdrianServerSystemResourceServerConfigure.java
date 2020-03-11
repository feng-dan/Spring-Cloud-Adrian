package kim.adrian.system.configure;

import com.adrian.common.handler.AdrianAccessDeniedHandler;
import com.adrian.common.handler.AdrianAuthExceptionEntryPoint;
import kim.adrian.system.properties.AdrianServerSystemProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * docker run -d --name app-web -p 443:443 -p 80:80 -v /home/iboutoo/app/nginx/data:/usr/share/nginx/html  -v /home/iboutoo/app/nginx/config/nginx.conf:/etc/nginx/nginx.conf  -v /home/iboutoo/app/nginx/config/conf.d/default.conf:/etc/nginx/conf.d/default.conf -v /home/iboutoo/app/nginx/logs:/var/log/nginx  -v /home/iboutoo/app/nginx/ssl:/ssl nginx:latest
 *
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerSystemResourceServerConfigure
 * @Description
 * @Date 2019-12-25 23:42
 */
@Configuration
@EnableResourceServer
public class AdrianServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {

    private final AdrianServerSystemProperties properties;
    private final AdrianAccessDeniedHandler accessDeniedHandler;
    private final AdrianAuthExceptionEntryPoint exceptionEntryPoint;

    public AdrianServerSystemResourceServerConfigure(AdrianServerSystemProperties adrianServerSystemProperties, AdrianAccessDeniedHandler accessDeniedHandler, AdrianAuthExceptionEntryPoint exceptionEntryPoint) {
        this.properties = adrianServerSystemProperties;
        this.accessDeniedHandler = accessDeniedHandler;
        this.exceptionEntryPoint = exceptionEntryPoint;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

}

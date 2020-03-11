package kim.adrian.gateway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianGateWayCorsConfigure
 * @Description
 * @Date 2020-01-03 14:10
 */
@Configuration
public class AdrianGateWayCorsConfigure {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        //表示允许cookie跨域；
        corsConfiguration.setAllowCredentials(true);
        //表示请求头部允许携带任何内容；
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        //表示允许任何来源；
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        //表示允许任何HTTP方法。
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}

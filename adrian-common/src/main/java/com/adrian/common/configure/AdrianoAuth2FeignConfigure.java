package com.adrian.common.configure;

import com.adrian.common.entity.AdrianConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianOAuth2FeignConfigure
 * @Description
 * @Date 2020-01-03 13:20
 */
public class AdrianoAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> {
            // 添加 Zuul Token
            String zuulToken = new String(Base64Utils.encode(AdrianConstant.ZUUL_TOKEN_VALUE.getBytes()));
            requestTemplate.header(AdrianConstant.ZUUL_TOKEN_HEADER, zuulToken);

            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
            }
        };
    }
}

package com.adrian.common.configure;

import com.adrian.common.interceptor.AdrianServerProtectInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianServerProtectConfigure
 * @Description
 * @Date 2020-01-03 13:36
 */
public class AdrianServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HandlerInterceptor adrianServerProtectInterceptor() {
        return new AdrianServerProtectInterceptor();
    }

    /**
     * Method annotated with @Bean is called directly. Use dependency injection instead.
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adrianServerProtectInterceptor());
    }
}

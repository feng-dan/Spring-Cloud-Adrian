package com.adrian.common.configure;

import com.adrian.common.handler.AdrianAccessDeniedHandler;
import com.adrian.common.handler.AdrianAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @ @ConditionalOnMissingBean IOC容器中没有指定名称或类型的Bean的时候，就注册它
 *
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAuthExceptionConfigure
 * @Description
 * @Date 2019-12-31 18:40
 */
public class AdrianAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public AdrianAccessDeniedHandler accessDeniedHandler() {
        return new AdrianAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public AdrianAuthExceptionEntryPoint authenticationEntryPoint() {
        return new AdrianAuthExceptionEntryPoint();
    }

}

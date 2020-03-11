package com.adrian.common.annotation;

import com.adrian.common.configure.AdrianoAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName EnableAdrianOauth2FeignClient
 * @Description
 * @Date 2020-01-03 13:22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AdrianoAuth2FeignConfigure.class)
public @interface EnableAdrianOauth2FeignClient {
}

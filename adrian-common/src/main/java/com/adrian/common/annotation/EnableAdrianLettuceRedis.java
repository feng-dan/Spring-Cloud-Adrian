package com.adrian.common.annotation;

import com.adrian.common.configure.AdrianLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName EnableAdrianLettuceRedis
 * @Description
 * @Date 2020-01-07 10:56
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AdrianLettuceRedisConfigure.class)
public @interface EnableAdrianLettuceRedis {
}

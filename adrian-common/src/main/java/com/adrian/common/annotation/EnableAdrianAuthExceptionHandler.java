package com.adrian.common.annotation;

import com.adrian.common.configure.AdrianAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName EnableAdrianAuthExceptionHandler
 * @Description
 * @Date 2020-01-02 11:24
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AdrianAuthExceptionConfigure.class)
public @interface EnableAdrianAuthExceptionHandler {
}

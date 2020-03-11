package com.adrian.common.annotation;

import com.adrian.common.configure.AdrianServerProtectConfigure;
import com.adrian.common.configure.AdrianoAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName EnableAdrianServerProtect
 * @Description
 * @Date 2020-01-03 13:42
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AdrianServerProtectConfigure.class)
public @interface EnableAdrianServerProtect {
}

package com.adrian.common.annotation;

import com.adrian.common.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName IsMobile
 * @Description 自定义参数校验注解
 * @Date 2020-01-11 13:12
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

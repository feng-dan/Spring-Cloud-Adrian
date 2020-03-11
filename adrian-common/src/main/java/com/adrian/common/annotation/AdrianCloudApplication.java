package com.adrian.common.annotation;

import com.adrian.common.selector.AdrianCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianCloudApplication
 * @Description
 * @Date 2020-01-03 13:50
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({AdrianCloudApplicationSelector.class})
public @interface AdrianCloudApplication {
}

package com.adrian.common.selector;

import com.adrian.common.configure.AdrianAuthExceptionConfigure;
import com.adrian.common.configure.AdrianServerProtectConfigure;
import com.adrian.common.configure.AdrianoAuth2FeignConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName FebsCloudApplicationSelector
 * @Description
 * @Date 2020-01-03 13:48
 */
public class AdrianCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                AdrianAuthExceptionConfigure.class.getName(),
                AdrianoAuth2FeignConfigure.class.getName(),
                AdrianServerProtectConfigure.class.getName()
        };
    }
}

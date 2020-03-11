package com.adrian.common.validator;

import com.adrian.common.annotation.IsMobile;
import com.adrian.common.entity.RegexpConstant;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName MobileValidator
 * @Description
 * @Date 2020-01-11 13:16
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {


    @Override
    public void initialize(IsMobile constraintAnnotation) {

    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean match(String regex, String value) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}

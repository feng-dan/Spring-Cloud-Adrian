package com.adrian.common.entity;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName RegexpConstant
 * @Description
 * @Date 2020-01-11 13:18
 */
public class RegexpConstant {
    /**
     * 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
     */
    public static final String MOBILE_REG = "[1]\\d{10}";
}

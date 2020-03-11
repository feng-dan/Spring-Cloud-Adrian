package com.adrian.common.entity;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianConstant
 * @Description
 * @Date 2020-01-03 13:31
 */
public class AdrianConstant {
    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String ZUUL_TOKEN_HEADER = "ZuulToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String ZUUL_TOKEN_VALUE = "adrian:zuul:123456";

    /**
     * gif类型
     */
    public static final String GIF = "gif";
    /**
     * png类型
     */
    public static final String PNG = "png";

    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "adrian.captcha.";
}

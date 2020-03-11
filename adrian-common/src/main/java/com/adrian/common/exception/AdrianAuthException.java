package com.adrian.common.exception;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName AdrianAuthException
 * @Description 自定义异常
 * @Date 2019-12-17 22:21
 */
public class AdrianAuthException extends BaseException {
    public AdrianAuthException(ErrorType errorType, String message) {
        super(errorType, message);
    }

    public AdrianAuthException(ErrorType errorType) {
        super(errorType);
    }
}

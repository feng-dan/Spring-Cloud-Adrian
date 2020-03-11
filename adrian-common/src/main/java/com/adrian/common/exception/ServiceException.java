package com.adrian.common.exception;


/**
 * @author feng-dan
 */
public class ServiceException extends BaseException {

    //TODO 对业务异常的返回码进行校验，规范到一定范围内

    public ServiceException(ErrorType errorType, String message) {
        super(errorType, message);
    }

    public ServiceException(ErrorType errorType) {
        super(errorType);
    }

    public ServiceException(ErrorType errorType, String message, Throwable cause) {
        super(errorType, message, cause);
    }
}

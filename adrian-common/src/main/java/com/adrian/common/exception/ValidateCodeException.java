package com.adrian.common.exception;

/**
 * @author by feng-dan
 * @version 1.0v
 * @ClassName ValidateCodeException
 * @Description
 * @Date 2020-01-07 11:22
 */
public class ValidateCodeException extends Exception {
    private static final long serialVersionUID = 7514854456967620043L;

    public ValidateCodeException(String message) {
        super(message);
    }
}

package com.mall.db.exception;


public class ServiceBadArgumentException extends RuntimeException {

    public ServiceBadArgumentException() {}

    /**
     * @param message 异常消息.
     */
    public ServiceBadArgumentException(String message) {
        super(message);
    }

    /**
     * @param cause 根异常.
     */
    public ServiceBadArgumentException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message 异常消息.
     * @param cause   根异常.
     */
    public ServiceBadArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}

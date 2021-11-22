package com.mall.core.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private ErrorCode error;

    /**
     * 无参数自定义业务异常构造方法.
     */
    public BusinessException() {

    }

    /**
     * @param message 异常消息.
     */
    public BusinessException(String message) {

        super(message);
    }

    /**
     * @param cause 根异常.
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }
    /**
     * @param message 异常消息.
     * @param cause   根异常.
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getError()
    {
        return error;
    }
}

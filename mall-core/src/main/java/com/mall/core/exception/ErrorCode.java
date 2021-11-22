package com.mall.core.exception;

public class ErrorCode {

    private String code;
    private String description;
    private String details;
    private Throwable cause;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public ErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ErrorCode(String code, String description, Throwable cause) {
        this.code = code;
        this.description = description;
        this.cause = cause;
    }
}

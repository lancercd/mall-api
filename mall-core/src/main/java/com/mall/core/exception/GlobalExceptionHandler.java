package com.mall.core.exception;


import com.mall.core.utils.ResponseUtil;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Object badArgumentHandler(IllegalArgumentException e) {
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Object badArgumentHandler(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object badArgumentHandler(MissingServletRequestParameterException e) {
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object badArgumentHandler(HttpMessageNotReadableException e) {
        e.printStackTrace();
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String defaultMessage = null;
        if (fieldError != null) {
            defaultMessage = fieldError.getDefaultMessage();
        }
        return ResponseUtil.badArgumentValue(defaultMessage);
    }


    @ExceptionHandler(value = TokenException.class)
    public Object TokenExceptionHandler(){

        return ResponseUtil.fail(401 , "请登录");
    }


    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public Object maximumUploadSizeExceeded(MaxUploadSizeExceededException e){
        Throwable cause = e.getCause().getCause();
        String msg = null;
        if (cause instanceof FileSizeLimitExceededException) {
            msg = "上传文件过大!";
        } else if (cause instanceof SizeLimitExceededException) {
            msg = "上传总文件大小过大！";
        }else {
            msg = "文件上传失败!";
        }
        System.out.println(cause.getMessage());
        System.out.println(msg);
        return ResponseUtil.fail(400 , msg);
    }


    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, NoHandlerFoundException.class})
    public Object MethodNotSupportedExceptionHandler(){

        return ResponseUtil.fail(404 , "Not Found!");
    }


    @ExceptionHandler(Exception.class)
    public Object seriousHandler(Exception e) {
        e.printStackTrace();
        return ResponseUtil.serious();
    }

}

package com.mall.core.exception;


import com.mall.core.utils.ResponseUtil;
import com.mall.db.exception.ServiceBadArgumentException;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler({
            ServiceBadArgumentException.class,
            IllegalArgumentException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class
    })
    public Object argumentExceptionHandler(Exception e) {
        e.printStackTrace();
        System.out.println("参数错误");
        System.out.println(e.getMessage());
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        String defaultMessage = null;
        if (fieldError != null) {
            defaultMessage = fieldError.getDefaultMessage();
        }
        return ResponseUtil.badArgumentValue(defaultMessage);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object DataIntegrityViolationExceptionHandler(DataIntegrityViolationException e){
        e.printStackTrace();

        Throwable cause = e.getCause();

        // 数据超过数据库该字段类型长度
        if (cause instanceof MysqlDataTruncation) {
            String message = cause.getMessage();
            System.out.println(message);
            return ResponseUtil.fail(message);
        }

        System.out.println(e.getMessage());
        return ResponseUtil.updatedDataFailed();
    }


    @ExceptionHandler(TokenException.class)
    public Object TokenExceptionHandler(){

        return ResponseUtil.fail(401 , "请登录");
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
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

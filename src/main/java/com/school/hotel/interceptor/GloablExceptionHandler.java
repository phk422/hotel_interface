package com.school.hotel.interceptor;

import com.school.hotel.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 用于处理全局抛出的异常
 * @Autor Peng hk
 * @Date 2021/2/26
 **/
//@RestControllerAdvice
public class GloablExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        return Result.error(msg);
    }
}

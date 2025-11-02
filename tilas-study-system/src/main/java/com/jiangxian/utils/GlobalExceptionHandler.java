package com.jiangxian.utils;


import com.jiangxian.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public Result globalExceptionHandler(Exception e){
        e.printStackTrace();
        return Result.error("错误,请联系开发者");
    }
}

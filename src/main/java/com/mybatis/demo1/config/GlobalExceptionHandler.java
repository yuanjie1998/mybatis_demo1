package com.mybatis.demo1.config;

import com.mybatis.demo1.entity.RetEntity;
import com.mybatis.demo1.exception.IllegaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常类处理
 * @Author yuan jie
 * @Date 2021/4/2 13:52
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            IllegaException.class
    })
    @ResponseBody
    public RetEntity errorHand(Exception e){
        if (e instanceof IllegaException){
            return RetEntity.error().setMessage(e.getMessage());
        }
        return RetEntity.error().setMessage("有错误了...");
    }
}

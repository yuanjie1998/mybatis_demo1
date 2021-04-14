package com.mybatis.demo1.exception;

/**
 * 非法异常类
 * @Author yuan jie
 * @Date 2021/4/2 13:53
 */
public class IllegaException extends RuntimeException{

    public IllegaException(String message){
        super(message);
    }

}

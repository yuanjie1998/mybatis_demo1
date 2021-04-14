package com.mybatis.demo1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatis.demo1.Enum.RetEntityEnum;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * 统一返回类(泛型)
 * @Author yuan jie
 * @Date 2021/4/2 13:51
 */
public class RetEntity<T> {
    private Integer code;
    private T body;
    @JsonFormat(
            pattern ="yyyy-MM-dd HH:mm:ss",
            timezone ="GMT+8"
    )
    private Date timestamp;
    private boolean status;
    private String message;

    public RetEntity() {
    }

    public RetEntity(Integer code, T body, Date timestamp, boolean status) {
        this.code = code;
        this.body = body;
        this.timestamp = timestamp;
        this.status = status;
    }

    public static RetEntity error() {
        return error((Integer)null);
    }
    public static RetEntity error(Integer code){
        return error(code,(String)null);
    }

    public static RetEntity error(Integer code,String message) {
        if (code == null){
            code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        if (message == null){
            message = RetEntityEnum.UNSUCCESSFUL.getCodeDesc();
        }
        return build(code,false,message);
    }

    public static RetEntity ok (){
        return ok ((Integer)null);
    }
    public static RetEntity ok (Integer code){
        return ok (code,(String)null);
    }
    public static RetEntity ok (Integer code,String message){
        if (code == null){
            code = HttpStatus.OK.value();
        }
        if (message == null){
            message = RetEntityEnum.SUCCESSFUL.getCodeDesc();
        }
        return build(code,true,message);
    }

    public static RetEntity build(Integer code,boolean status,String message){
        return (new RetEntity()).setCode(code).setStatus(status).setTimestamp(new Date()).setMessage(message);
    }

    public Integer getCode() {
        return code;
    }

    public RetEntity setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getBody() {
        return body;
    }

    public RetEntity setBody(T body) {
        this.body = body;
        return this;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public RetEntity setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public RetEntity setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RetEntity setMessage(String message) {
        this.message = message;
        return this;
    }
}

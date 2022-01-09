package com.dabaoqiang.jwt.common.result;

import java.io.Serializable;

/**
 * @author xq
 */
public class Result<T> implements Serializable {

    public T data;

    private String code;

    private String message;

    public static Result ok() {
        return new Result("SUCCESS", "请求处理成功");
    }

    public static Result ok(Object data) {
        return new Result("SUCCESS", "请求处理成功", data);
    }

    public static Result<Object> fail(Object object) {
        return new Result("FAIL", "请求处理失败", object);
    }




    private Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

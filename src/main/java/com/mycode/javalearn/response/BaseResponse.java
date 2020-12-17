package com.mycode.javalearn.response;

/**
 * @Description BaseResponse
 * @Author toolman
 * @Date 2020/12/15 22:35
 **/
public class BaseResponse {
    private int code = 200;
    private String message;

    public BaseResponse() {
    }

    public BaseResponse(int cde, String message) {
        this.code = cde;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

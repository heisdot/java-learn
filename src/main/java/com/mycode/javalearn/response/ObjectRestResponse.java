package com.mycode.javalearn.response;

/**
 * @Description 单个对象返回数据格式
 * @Author toolman
 * @Date 2020/12/15 22:36
 **/
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse() {
    }

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ObjectRestResponse ok(Object data) {
        return (new ObjectRestResponse()).data(data);
    }

    @Deprecated
    public static ObjectRestResponse ok() {
        return new ObjectRestResponse();
    }

    public static ObjectRestResponse fail(int code, String message) {
        ObjectRestResponse response = new ObjectRestResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    @Deprecated
    public static ObjectRestResponse fail(String message) {
        ObjectRestResponse response = new ObjectRestResponse();
        response.setCode(500);
        response.setMessage(message);
        return response;
    }
}

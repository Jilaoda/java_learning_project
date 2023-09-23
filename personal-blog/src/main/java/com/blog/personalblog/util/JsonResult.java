package com.blog.personalblog.util;

import java.io.Serializable;

/**
 * @author liweiliang
 * @create 2023-05-09 21:40:55
 * @description  这个类的作用是定义一个用于返回JSON格式数据的标准数据结构，
 *               包括操作状态码、状态信息和数据。可以用于前后端数据交互，统
 *               一返回数据格式，方便前端页面数据处理和展示。
 */
public class JsonResult<T> implements Serializable {

    // 这个接口实际上是用于序列化/反序列化的，可以将对象转换为二进制数据进行传输或持久化。
    private static final long serialVersionUID = 1L;

    //声明了两个静态常量，分别表示成功和失败的响应状态码。
    public static final int SUCCESS = 200;
    public static final int error = 500;

    //code表示响应状态码，msg表示响应信息，data表示响应数据
    private int code;
    private String msg;
    private T data;

    public static <T> JsonResult<T> success() {
        return jsonResult(null, SUCCESS, "操作成功");
    }

    public static <T> JsonResult<T> success(T data) {
        return jsonResult(data, SUCCESS, "操作成功");
    }


    public static <T> JsonResult<T> error() {
        return jsonResult(null, error, "操作失败");
    }

    public static <T> JsonResult<T> error(String msg) {
        return jsonResult(null, error, msg);
    }

    public static <T> JsonResult<T> error(T data) {
        return jsonResult(data, error, "操作失败");
    }

    private static <T> JsonResult<T> jsonResult(T data, int code, String msg) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    //定义getter、setter方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

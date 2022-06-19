package com.wliang.prudential.common;

import java.io.Serializable;

public class WrapperResponse<T> implements Serializable {
    private static int successCode = 00000;
    private static int failCode = 99999;
    private static String successMsg = "success";
    private static String failMsg = "fail";

    private int code;
    private String msg;
    private T param;

    public WrapperResponse(int code, String msg, T param) {
        this.code = code;
        this.msg = msg;
        this.param = param;
    }

    public WrapperResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public static <T> WrapperResponse<T> success(T param){
        return new WrapperResponse<T>(successCode,successMsg,param);
    }

    public static <T> WrapperResponse<T> success(){
        return new WrapperResponse<T>(successCode,successMsg);
    }

    public static <T> WrapperResponse<T> fail(T param){
        return new WrapperResponse<T>(failCode,failMsg,param);
    }

    public static <T> WrapperResponse<T> fail(String failMsg){
        return new WrapperResponse<T>(failCode,failMsg,null);
    }

    public static <T> WrapperResponse<T> fail(){
        return new WrapperResponse<T>(failCode,failMsg);
    }

    public static <T> WrapperResponse<T> fail(int code,String msg){
        return new WrapperResponse<T>(code,msg);
    }
}

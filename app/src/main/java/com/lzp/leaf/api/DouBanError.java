package com.lzp.leaf.api;

/**
 * Created by lzp on 2017/8/5.
 */

public class DouBanError {
    private int code;
    private String msg;
    private String request;

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

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}

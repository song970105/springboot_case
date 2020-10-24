package com.atguigu.springboot.util;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean status;
    private String msg;
    private Object data;

    public static Result ok(boolean status,String msg,Object data){
        Result result =new Result();
        result.setData(data);
        result.setMsg(msg );
        result.setStatus(status);
        return result;
    }
    public static Result error(boolean status,String msg){
        Result result =new Result();

        result.setMsg(msg );
        result.setStatus(status);
        result.setData(null);
        return result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

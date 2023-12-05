package com.my.app.exception;

public class MyAppException extends RuntimeException{
    private String msg;
    private int code;


    public MyAppException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

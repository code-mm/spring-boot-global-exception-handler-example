package com.my.app.exception;


import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Throwable e) {
        e.printStackTrace();

        // 自定义运行时异常
        if (e instanceof MyAppException appException) {
            int code = appException.getCode();
            String msg = appException.getMsg();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", code);
            jsonObject.put("message", msg);
            String r = jsonObject.toString();
            return new ResponseEntity<>(r, HttpStatus.OK);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", -1);
        jsonObject.put("message", "未知异常,请联系管理员");
        String r = jsonObject.toString();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

package com.my.app.controller;


import com.my.app.exception.MyAppException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test1")
    public String a(){
        throw new MyAppException("测试全局捕获异常",10001);
    }
}

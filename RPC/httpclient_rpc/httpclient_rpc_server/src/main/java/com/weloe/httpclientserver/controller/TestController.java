package com.weloe.httpclientserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/params",produces = {"application/json;charset=UTF-8"})
    public String params(String name,String password){
        System.out.println(name + password);
        return name+password;
    }

    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"})
    public String test(){
        return "test";
    }

}

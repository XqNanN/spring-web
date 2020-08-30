package com.nan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

   // @ResponseBody
    @RequestMapping("/test")
    public String helloWorld(Map<String,Object> map){

        map.put("hello","<h3>你好</h3>");
        map.put("users", Arrays.asList("jake","lufie","kakaxi"));
        return "test";
    }

}

package com.nan.controller;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord,
    Map<String,Object> map,HttpSession session){
        if(!StringUtils.isEmpty(userName)&&"123456".equals(passWord)){
            session.setAttribute("loginUser",userName);
            return "redirect:/main";

        }else {
            map.put("message","用户名或密码错误");
            return "login";
        }

    }
}

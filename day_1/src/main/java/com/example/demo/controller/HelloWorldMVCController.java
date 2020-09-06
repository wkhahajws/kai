package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:HelloWorldMVCController
 * Author: kaishen
 * Date: 2020/9/6 9:22
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Controller
public class HelloWorldMVCController {

    @RequestMapping("/helloMVC")
    public String sayhelloWorld(Model mv){
        mv.addAttribute("name","hello,Spring boot MVC");
        return "index";
    }

    @GetMapping("/getUser")
    public ModelAndView getUser(){
        ModelAndView mv = new ModelAndView("getUser");
        User user = new User();
        user.setName("jinwenshu");
        user.setAge(20);
        mv.addObject("user",user);
        return mv;
    }
}

package com.example.demo.controller;

import com.example.demo.entity.U;
import com.example.demo.mapper.UMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * FileName:UController
 * Author: kaishen
 * Date: 2020/10/26 21:38
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

//@RestController
@Controller
@RequestMapping("u")
public class UController {
    @Autowired
    private UMapper uMapper;

    @GetMapping("/variable")
    public ModelAndView findById(){
        ModelAndView mv = new ModelAndView("thymeleaf");
        String kai = "kai";
        Integer age = 25;
        mv.addObject("name",kai);
        mv.addObject("age",age);
        return mv;
    }

    @RequestMapping("/findByid")
    public U findById(String id){
        U u = uMapper.queryById(id);
        return u;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "start",defaultValue = "0") int start,
                           @RequestParam(name = "size",defaultValue = "2") int size){
        PageHelper.startPage(start,size,"id desc");
        List<U> list = uMapper.queryAll();
        PageInfo<U> page = new PageInfo<>(list);
        model.addAttribute("page",page);
        return "u/list";
    }

    @RequestMapping("/add")
    @ResponseBody
    String add(U u){
        int i = uMapper.add(u);
        return i == 1?"success":"failed";
    }

    @RequestMapping("/update")
    String updateById(U u){
        int i = uMapper.updateById(u);
        return i == 1?"success":"failed";
    }

    @RequestMapping("/delById")
    String delById(String id){
        int i = uMapper.delById(id);
        return i == 1?"success":"failed";
    }

}

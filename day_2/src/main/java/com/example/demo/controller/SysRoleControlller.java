package com.example.demo.controller;

import com.example.demo.entity.sysuser.SysRole;
import com.example.demo.repository.sysuser.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FileName:SysRoleControlller
 * Author: kaishen
 * Date: 2020/10/22 15:09
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Controller
@RequestMapping("admin")
public class SysRoleControlller {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @RequestMapping("/role/add")
    public String addRole(){
        return "admin/role/add";
    }

    @RequestMapping("/role")
    public String addRole(SysRole model){
        String role = "ROLE_" + model.getRole();
        model.setRole(role);
        sysRoleRepository.save(model);
        return "redirect:/admin/";
    }
}

package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * FileName:WebMvcConfig
 * Author: kaishen
 * Date: 2020/10/6 15:55
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置登录处理操作
        /*registry.addViewController("/home/login").setViewName("user/login");
        registry.addViewController("/admin/login").setViewName("admin/login");
        registry.addViewController("/admin/rbac").setViewName("admin/test");*/

        /*registry.addViewController("/home/login").setViewName("home/login");*/
        registry.addViewController("home/login").setViewName("home/login");
        /*registry.addViewController("/admin/login").setViewName("admin/login");
        registry.addViewController("/jwt/login").setViewName("jwt/login");*/
    }
}

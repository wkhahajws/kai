package com.example.demo.config;

import com.example.demo.config.authenticationhandler.MyAuthenticationFailHandler;
import com.example.demo.config.authenticationhandler.MyAuthenticationSuccessHandler;
import com.example.demo.service.M_UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * FileName:WebSecurityConfig
 * Author: kaishen
 * Date: 2020/10/27 18:53
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Configuration
//指定为SpringSecurity配置类，如果是webFlux，则需要启用@EnableWebFluxSecurity
@EnableWebSecurity
//要启用方法安全设置，则开启此项
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class WebSecurityConfig{


    @Configuration
    @Order(1)
    public class WebSecurityConfigForUser extends WebSecurityConfigurerAdapter {
        @Autowired
        private MyAuthenticationFailHandler myAuthenticationFailHandler;
        @Autowired
        private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();   // 使用 BCrypt 加密
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // http.antMatcher("/home/**").
            //为了在product页面获取到用户信息,进行了url修改.2019.4.12
            http.antMatcher("/**").
                    //指定登录认证的Controller
                            formLogin().usernameParameter("name").passwordParameter("password").loginPage("/home/login").successHandler(
                    myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailHandler)
                    .and()
                    .authorizeRequests()
                    //登录相关
                    .antMatchers("/home/login", "/home/register/mobile", "/home/register/email").permitAll()
                    .antMatchers("/home/**").hasRole("USER")
                    //限制购物车必须登录
                    .antMatchers("/cart/","/cart").hasRole("USER");


            //rabc相关

            http.logout().logoutUrl("/home/logout").permitAll();
            http.rememberMe().rememberMeParameter("rememberme");//记住我功能
            http.headers().frameOptions().sameOrigin();//解决X-Frame-Options deny 造成的页面空白,不然后台不能用frame
        }

        @Bean
        M_UserSecurityService m_userSecurityService() {
            return new M_UserSecurityService();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(m_userSecurityService()).passwordEncoder(new BCryptPasswordEncoder() {
            });
        }
    }

}

package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:SpringSecuritySimpleDemoApplicationTests
 * Author: kaishen
 * Date: 2020/10/7 8:25
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecuritySimpleDemoApplicationTests {
    @Test
    public void contextLoads() {
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        String encodePassword = encoder.encode("kaishen");
        System.out.println(encodePassword);
    }

}

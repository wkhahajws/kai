package com.example.demo.test;

import com.example.demo.mq.CustomSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:CustomTest
 * Author: kaishen
 * Date: 2020/9/11 22:36
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomTest {
    @Autowired
    private CustomSender customSender;
    @Test
    public void customTest(){
        customSender.sendMessage("支付超时，取消订单通知");
    }
}

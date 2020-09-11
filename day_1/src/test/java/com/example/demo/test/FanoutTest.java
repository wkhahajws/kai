package com.example.demo.test;

import com.example.demo.mq.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:FanoutTest
 * Author: kaishen
 * Date: 2020/9/11 21:50
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void fanoutTetst(){
        fanoutSender.send();
    }
}

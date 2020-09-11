package com.example.demo.test;

import com.example.demo.mq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:TopicSendControllerTest
 * Author: kaishen
 * Date: 2020/9/11 9:53
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicSendControllerTest {
    @Autowired
    private TopicSender sender;

    @Test
    public void topic(){
        sender.send();
    }

    @Test
    public void topic2(){
        sender.send2();
    }

    @Test
    public void topic3(){
        sender.send3();
    }
}

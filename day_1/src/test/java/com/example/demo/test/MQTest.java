package com.example.demo.test;

import com.example.demo.model.User;
import com.example.demo.mq.SenderA;
import com.example.demo.mq.UserQueue1Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * FileName:MQTest
 * Author: kaishen
 * Date: 2020/9/8 7:43
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MQTest {

    @Autowired
    private SenderA queueSender;

    @Autowired
    private UserQueue1Sender userQueue1Sender;

    @Test
    public void QueueSend(){
        int i = 2;
        for (int j = 0; j < i; j++) {
            String msg = "Queue1 msg"+j+new Date();
            queueSender.send(msg);
        }
    }

    @Test
    public void userQueueSend(){
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("kai_"+i);
            user.setAge(20+i);
            userQueue1Sender.send(user);
        }
    }
}

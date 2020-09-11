package com.example.demo.mq;

import com.example.demo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FileName:UserQueue1Sender
 * Author: kaishen
 * Date: 2020/9/8 8:16
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
public class UserQueue1Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user){
        System.out.println("Sender Object:"+user.toString());
        amqpTemplate.convertAndSend("UserQueue1",user);
    }
}

package com.example.demo.mq;

import com.example.demo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FileName:UserQueue1
 * Author: kaishen
 * Date: 2020/9/8 8:11
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
@RabbitListener(queues = "UserQueue1")
public class UserQueue1Receiver {

    @RabbitHandler
    public void userReceiver(User user){
        System.out.println("Receiver object"+ user);
    }
}

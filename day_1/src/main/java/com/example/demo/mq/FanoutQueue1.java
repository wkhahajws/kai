package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FileName:FanoutQueue1
 * Author: kaishen
 * Date: 2020/9/11 21:44
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
@RabbitListener(queues = "fanoutQueue1")
public class FanoutQueue1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("FanoutQueue1:"+message);
    }
}

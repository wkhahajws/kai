package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileName:CustomReceiver
 * Author: kaishen
 * Date: 2020/9/11 22:34
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
public class CustomReceiver {

    @RabbitListener(queues = "delay_queue_1")
    @RabbitHandler
    public void receive(String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+msg);
        System.out.println("执行取消订单");
    }
}

package com.example.demo.mq;

import com.example.demo.until.AsyncSendEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FileName:RegEmailQueueRecuiver
 * Author: kaishen
 * Date: 2020/11/3 13:46
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
@RabbitListener(queues = "reg_email")
public class RegEmailQueueRecuiver {

    @Autowired
    private AsyncSendEmailService asyncSendEmailService;

    @RabbitHandler
    public void QueueRecuiver(String reg_email){
        //
        asyncSendEmailService.sendVerifyemail(reg_email);
        System.out.println(reg_email);
    }
}

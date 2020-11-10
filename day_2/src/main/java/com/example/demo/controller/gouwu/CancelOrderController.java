package com.example.demo.controller.gouwu;

import com.example.demo.mq.CancelOrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:CancelOrderController
 * Author: kaishen
 * Date: 2020/11/3 22:58
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
public class CancelOrderController {

    @Autowired
    private CancelOrderSender cancelOrderSender;
    int orderId = 1;

    @GetMapping("/customSend")
    public void send() {
        cancelOrderSender.sendMsg("delay_queue_1", orderId);
    }
}

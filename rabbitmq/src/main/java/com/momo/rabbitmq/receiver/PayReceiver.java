package com.momo.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 9:52
 **/
@Component
@RabbitListener(queues = "pay")
public class PayReceiver {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("PayReceiver :" + msg);
    }
}

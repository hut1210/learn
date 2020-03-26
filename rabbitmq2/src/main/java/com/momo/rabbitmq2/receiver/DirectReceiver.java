package com.momo.rabbitmq2.receiver;

import com.momo.rabbitmq2.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 11:35
 **/
@Component
public class DirectReceiver {

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_NAME1)
    public void receiver1(String message){
        System.out.println("【receiveDirect1监听到消息】" + message);
        System.out.println(1/0);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE_NAME2)
    public void receiver2(String message){
        System.out.println("【receiveDirect2监听到消息】" + message);
    }
}

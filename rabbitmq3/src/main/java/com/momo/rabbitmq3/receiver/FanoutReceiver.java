package com.momo.rabbitmq3.receiver;

import com.momo.rabbitmq3.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 14:33
 **/
@Component
public class FanoutReceiver {

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiver1(String message){
        System.out.println("【receiveFanout1监听到消息】" + message);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiver2(String message){
        System.out.println("【receiveFanout2监听到消息】" + message);
    }
}

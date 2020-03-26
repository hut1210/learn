package com.momo.rabbitmq2.sender;

import com.momo.rabbitmq2.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Hut
 * @Date: 2020/03/20 11:34
 **/
@Component
public class DirectSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message){
        rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,"direct.pwl",111);
        //rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE,"direct.info",123);
    }
}

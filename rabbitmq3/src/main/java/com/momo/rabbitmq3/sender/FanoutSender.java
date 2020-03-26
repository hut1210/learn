package com.momo.rabbitmq3.sender;

import com.momo.rabbitmq3.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 14:36
 **/
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        amqpTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE,"","fanout");
    }
}

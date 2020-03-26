package com.momo.rabbitmq5.sender;

import com.momo.rabbitmq5.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Hut
 * @Date: 2020/03/23 10:29
 **/
@Component
public class Sender {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    public void sender(String message){
        if(redisTemplate.hasKey(message)) {
            System.out.println("redis已经有了");
            return;
        }
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,RabbitConfig.ORDER_ROUTING_KEY,message);
    }
}

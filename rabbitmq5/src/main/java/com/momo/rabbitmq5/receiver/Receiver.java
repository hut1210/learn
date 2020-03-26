package com.momo.rabbitmq5.receiver;

import com.momo.rabbitmq5.config.RabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author: Hut
 * @Date: 2020/03/23 10:29
 **/
@Component
public class Receiver {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE_NAME)
    public void receiver1(String msg, Channel channel, Message message) throws IOException {
        try {
            //这里写你的消费逻辑，如果出错，会被catch
            redisTemplate.opsForValue().set("123",msg);
            System.out.println("【receiveDirect1监听到消息】" + message);
            //System.out.println(1/0);
        } catch (Exception e) {
            //这段代码表示，这次消息，我已经接受并消费掉了，不会再重复发送消费
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}

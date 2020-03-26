package com.momo.rabbitmq5;

import com.momo.rabbitmq5.sender.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Rabbitmq5ApplicationTests {

    @Resource
    private Sender sender;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSender(){
        sender.sender("123");
    }



}

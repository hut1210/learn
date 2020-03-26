package com.momo.rabbitmq3;

import com.momo.rabbitmq3.sender.FanoutSender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Rabbitmq3ApplicationTests {

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSender(){
        fanoutSender.send();
    }

}

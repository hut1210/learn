package com.momo.rabbitmq4;

import com.momo.rabbitmq4.sender.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Rabbitmq4ApplicationTests {

    @Autowired
    private TopicSender topicSender;
    @Test
    void contextLoads() {
    }

    @Test
    public void testSend(){
        topicSender.send();
    }
}

package com.jk.cj.test2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String content = "hello   hhhhhhhh";
        this.amqpTemplate.convertAndSend("exchage_topic","topic.delete",content);
        System.out.println("发送者发送"+content);
    }
}

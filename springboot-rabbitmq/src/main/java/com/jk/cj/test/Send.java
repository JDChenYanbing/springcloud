package com.jk.cj.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send {

    /*@Autowired
    private AmqpTemplate rabbitmqTemplate;


    public void send(){
        String content = "这是一条我发送的消息";
        System.out.println("发送者:" +content);
        this.rabbitmqTemplate.convertAndSend("message", content);
    }*/
}

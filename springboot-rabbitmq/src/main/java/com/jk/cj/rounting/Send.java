package com.jk.cj.rounting;

import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {


    private static final String EXCHANGE_NAME = "routing";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");

        channel.basicQos(1);
        String mess = "hi";
        String key = "info";
        channel.basicPublish(EXCHANGE_NAME,key,null,mess.getBytes());
        System.out.println("发送者"+mess);

        channel.close();
        connection.close();

    }


}

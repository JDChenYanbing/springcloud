package com.jk.cj.sim;

import com.jk.cj.UserBean;
import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.*;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive {

    private static final String QUEUE_NAME = "simp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {



            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                byte[] clone = body.clone();

                UserBean user =new UserBean();
                BeanUtils.copyProperties(clone,user);
                String s = new String(body, "utf-8");
                System.out.println("接收者"+user);
            }
        };

        channel.basicConsume(QUEUE_NAME, true, defaultConsumer);

    }

}

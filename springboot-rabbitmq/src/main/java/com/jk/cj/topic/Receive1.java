package com.jk.cj.topic;

import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive1 {

    private static final String QUEUE_NAME = "work_queue1";
    private static final String EXCHANGE_NAME = "routing";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.basicQos(1);
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"good.delete");

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String s = new String(body, "utf-8");
                System.out.println("接收者1"+s);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }


            }
        };

        Boolean flag = false;
        channel.basicConsume(QUEUE_NAME, flag, defaultConsumer);

    }

}

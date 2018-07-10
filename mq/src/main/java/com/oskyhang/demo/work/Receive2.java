package com.oskyhang.demo.work;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/5 <br/>
 */
public class Receive2 {
    private final static String QUEUE_NAME = "work_queue";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            String message = new String(delivery.getBody());

            System.out.println("rece2: " + message);

            Thread.sleep(1000);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }
    }


}

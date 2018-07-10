package com.oskyhang.demo.topic;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/5 <br/>
 */
public class Receiver {
    private final static String QUEUE_NAME = "topic_quque";
    private final static String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "key.*");
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("Receive : " + message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }
    }
}

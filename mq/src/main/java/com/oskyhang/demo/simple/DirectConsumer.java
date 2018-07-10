package com.oskyhang.demo.simple;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/2 <br/>
 */
public class DirectConsumer {

    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //定义队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        //监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("Rective: {}" +  message);
        }


    }
}

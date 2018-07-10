package com.oskyhang.demo.routing;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/4 <br/>
 */
public class Receive {
    private final static String QUEUE_NAMW = "test_queue_work";
    private final static String EXCHANGE_NAME = "router_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAMW, false, false, false, null);
        //绑定交换机
        channel.queueBind(QUEUE_NAMW, EXCHANGE_NAME, "key");
        //同一时刻服务器只会发送一条消息给消费者
        channel.basicQos(1);

        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAMW, false, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("Receive: " + message);
            //Thread.sleep(1);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }

    }

}

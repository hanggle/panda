package com.oskyhang.demo.work;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/5 <br/>
 */
public class Receive {
    private final static String QUEUE_NAME = "work_queue";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列，手动返回完成状态
        channel.basicConsume(QUEUE_NAME, false, consumer);


        //获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            String message = new String(delivery.getBody());

            System.out.println("rece: " + message);

            Thread.sleep(100);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }
    }


}

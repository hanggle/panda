package com.oskyhang.demo.topic;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/5 <br/>
 */
public class Sender {

    private final static String EXCHANGE_NAME = "topic_exchange";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String message = "Hello world!";
        channel.basicPublish(EXCHANGE_NAME, "key.*", null, message.getBytes());

        System.out.println("Send:" + message);
        channel.close();
        connection.close();
    }
}

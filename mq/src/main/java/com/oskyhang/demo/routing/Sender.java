package com.oskyhang.demo.routing;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/4 <br/>
 */
public class Sender {
    private final static String EXCHANGE_NAME = "router_exchange";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        String message = "hello world!";
        channel.basicPublish(EXCHANGE_NAME, "key2", null, message.getBytes());
        System.out.println("send:" + message);
        channel.close();
        connection.close();

    }

}

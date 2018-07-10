package com.oskyhang.demo.simple;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.*;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/2 <br/>
 */
public class DirectProvider {

    private final static String QUEUE_NAME = "test_queue";

    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();

       //连接中创建通道
        Channel channel = connection.createChannel();

        //声明创建队列
        channel.queueDeclare(QUEUE_NAME,false, false, false, null);

        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        System.out.println("Send:" + message);
        channel.close();
        connection.close();
    }
}

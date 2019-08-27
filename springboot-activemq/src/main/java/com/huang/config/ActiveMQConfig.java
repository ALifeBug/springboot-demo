package com.huang.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

    /**
     * 能否多次消费:否
     * 消息生产者生产消息发送到queue中，然后消息消费者从queue中取出并消费消息
     * 消费被消费后，queue中不再有存储。queue支持存在多个消费者，但对于一个消息而言，只有一个消费者可以消费
     *
     * 是否需要提前订阅:否
     * 即使消费者之后启动，也能够接受到之前发的还在队列中的消息，可以消费之前的消息
     * @return
     */
    @Bean
    public Queue queue(){return new ActiveMQQueue("hqs-queue");}

    /**
     * 能否多次消费:能
     * 消息生产者发布消息到topic中，同时有多个消息消费者消费该消息，发布到topic的消息会被所有订阅者消费
     *
     * 是否需要提前订阅:是
     * 消费者无法接受到之前的消息，只能接受到开始监听时产生的所有消息，所以需要提前订阅
     * @return
     */
    @Bean
    public Topic topic(){return new ActiveMQTopic("hqs-topic");}


}

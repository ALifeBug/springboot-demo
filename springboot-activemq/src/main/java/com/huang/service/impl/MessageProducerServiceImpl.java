package com.huang.service.impl;

import com.huang.pojo.User;
import com.huang.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class MessageProducerServiceImpl implements MessageProducerService{

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    @Autowired
    Topic topic;

    @Override
    public void sendMsg(String message) {
        System.out.println("发送消息["+message+"]");
        //如果在配置文件中定义了默认地址，则不需要传递目的地址
        //jmsMessagingTemplate.convertAndSend(message);
        jmsMessagingTemplate.convertAndSend(queue,message);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送消息"+user);
        jmsMessagingTemplate.convertAndSend(topic,user);
    }
}

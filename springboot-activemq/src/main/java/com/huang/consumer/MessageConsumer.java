package com.huang.consumer;

import com.huang.pojo.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
public class MessageConsumer {

    /**
     * 这里的destination会自动创建，即如果没有对应的目标则会主动创建，
     * 具体创建的是queue还是topic根据配置文件中配置的当前模式决定
     * @param message
     */
    @JmsListener(destination = "hqs-queue")
    public void receiveMessage(Message message){
        System.out.println("接收到消息:["+message+"]");

    }

    @JmsListener(destination = "hqs-topic")
    public void receiveUser(User user){
        System.out.println("接收到消息:["+user+"]");
    }


    @JmsListener(destination = "test-autocreate-topic")
    public void receive(){
    }
}

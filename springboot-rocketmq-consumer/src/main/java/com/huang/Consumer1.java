package com.huang;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * Created by sccy on 2019/7/5/0005.
 */
@Service
@RocketMQMessageListener(consumerGroup = "my-consumer-group-topic-1", topic = "test-topic1")
public class Consumer1 implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("message:"+s);
    }
}

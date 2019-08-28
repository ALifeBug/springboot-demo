package com.huang;


import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * Created by sccy on 2019/7/5/0005.
 */
@Service
@RocketMQMessageListener(topic = "test-topic2",consumerGroup = "my-consumer-group-topic-2")
public class Consumer2 implements RocketMQListener<OrderPaidEvent> {
    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        System.out.println("orderPaidEvent:"+orderPaidEvent);
    }
}

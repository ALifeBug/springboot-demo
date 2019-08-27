package com.huang.service.impl;

import com.huang.pojo.User;
import com.huang.service.MessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageProducerServiceImplTest {

    @Autowired
    MessageProducerService messageProducerService;

    @Test
    public void sendMsg() {
        messageProducerService.sendMsg("神罗天征!");
    }

    @Test
    public void sendUser(){
        messageProducerService.sendUser(new User(1l,"hqs","pain"));
    }
}
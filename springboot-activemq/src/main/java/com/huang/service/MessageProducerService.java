package com.huang.service;

import com.huang.pojo.User;

public interface MessageProducerService {

    void sendMsg(String message);

    void sendUser(User user);
}

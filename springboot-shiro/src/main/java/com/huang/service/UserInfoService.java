package com.huang.service;

import com.huang.model.UserInfo;

public interface UserInfoService {
    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(String username);
}

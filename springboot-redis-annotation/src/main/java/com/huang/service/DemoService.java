package com.huang.service;

import com.huang.pojo.Address;
import com.huang.pojo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Cacheable(value = "usercache",key = "#id")
    public User findUser(Long id,String firstName,String lastName){
        System.out.println("无缓存的时候调用这里");
        return new User(id,firstName,lastName);
    }

    @Cacheable(value = "addressCache",keyGenerator = "keyGenerator")
    public Address findAddress(Long id,String province,String city){
        System.out.println("无缓存的时候调用这里");
        return new Address(id,province,city);
    }

    @CachePut(value = "usercache",key = "#id")
    public User updateUser(Long id,String firstName,String lastName){
        System.out.println("更新缓存");
        return new User(id,firstName,lastName);
    }

    @CacheEvict(value = "usercache",key = "#id")
    public void deleteUser(Long id){
        System.out.println("删除缓存");
    }
}

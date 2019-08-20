package com.huang.service;

import com.huang.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonService {

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    //注入redisTemplate,重定义了序列化器

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    //redisTemplate保存对象键值对
    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    public Person getPerson(String id){

        return (Person)valOps.get(id);
    }


}

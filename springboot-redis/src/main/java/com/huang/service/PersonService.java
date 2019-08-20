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
    StringRedisTemplate stringRedisTemplate;
    //直接注入springboot的stringRedisTemplate,该类继承了RedisTemplate并改写了序列化器为UTF-8的字符串序列化器,用于操作字符串

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;
    //使用stringRedisTemplate注入valueOperations,这里涉及到spring的注入原理，具体是由redistemplate的opsForValue()方法注入的

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    //直接注入redisTemplate,默认使用的是JDK的序列化器和反序列化器，用二进制形式存储数据，不直观;并且类需要实现序列化接口

    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    //stringRedisTemplate保存字符串键值对
    public void setStringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    //redisTemplate保存对象键值对
    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    //获取字符串
    public String getString(){
        return valOpsStr.get("xx");
    }

    public Person getPerson(){
        return (Person)valOps.get("1");
    }


}

package com.huang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisSerializer fastJosnRedisSerializer(){
        return new FastJsonRedisSerializer<>(Object.class);
    }

    @Bean(name = "redisTemplate")//默认情况下bean的名字和方法名相同
    public RedisTemplate initRedisTemplate(RedisConnectionFactory redisConnectionFactory,RedisSerializer fastJsonRedisSerializer){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);//值序列化用json序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());//键用string序列化器
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}

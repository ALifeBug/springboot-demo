package com.huang.service.impl;

import com.huang.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncServiceImplTest {

    @Autowired
    AsyncService asyncService;

    /**
     * 主方法和异步方法由不同的线程运行
     */
    @Test
    public void generateReport() {
        System.out.println("请求线程名称:"+"["+Thread.currentThread().getName()+"]");
        //调用异步服务
        asyncService.generateReport();
    }
}
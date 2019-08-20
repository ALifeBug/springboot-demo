package com.huang.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的add操作")
    public void add(){
        System.out.println("DemoAnnotationService..");
    }
}

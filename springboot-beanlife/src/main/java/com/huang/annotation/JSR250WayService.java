package com.huang.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by sccy on 2018/2/13/0013.
 */
public class JSR250WayService {
    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        super();
        System.out.println("构造函数:com.huang.JSR250WayService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}

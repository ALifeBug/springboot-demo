package com.huang.annotation;

/**
 * Created by sccy on 2018/2/13/0013.
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService(){
        super();
        System.out.println("构造函数-com.huang.BeanWayService");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}

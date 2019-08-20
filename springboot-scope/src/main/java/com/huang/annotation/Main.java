package com.huang.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sccy on 2018/2/13/0013.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SingletonService s1 = context.getBean(SingletonService.class);
        SingletonService s2 = context.getBean(SingletonService.class);
        System.out.println(s1==s2);
        PrototypeService p1 = context.getBean(PrototypeService.class);
        PrototypeService p2 = context.getBean(PrototypeService.class);
        System.out.println(p1==p2);
    }


}

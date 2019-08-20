package com.huang.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sccy on 2018/2/13/0013.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);
        context.close();
    }
}

package com.huang.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sccy on 2018/2/13/0013.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig config = context.getBean(ELConfig.class);
        config.output();
        context.close();
    }
}

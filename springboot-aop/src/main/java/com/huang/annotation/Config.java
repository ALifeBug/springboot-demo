package com.huang.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Configuration
@ComponentScan("com.huang")
@EnableAspectJAutoProxy
public class Config {
}

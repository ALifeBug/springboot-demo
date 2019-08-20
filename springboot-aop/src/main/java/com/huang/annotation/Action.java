package com.huang.annotation;

import java.lang.annotation.*;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}

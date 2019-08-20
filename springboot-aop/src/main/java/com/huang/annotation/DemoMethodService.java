package com.huang.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by sccy on 2019/7/9/0009.
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("DemoMethodService...");
    }
}

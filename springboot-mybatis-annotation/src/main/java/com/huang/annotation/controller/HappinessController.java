package com.huang.annotation.controller;

import com.huang.annotation.service.HappinessService;
import com.huang.annotation.vo.Happiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sccy on 2019/7/9/0009.
 */
@RestController
public class HappinessController {

    @Autowired
    private HappinessService happinessService;

    @RequestMapping("/query")
    public Happiness testQuery(){
        return happinessService.selectService("北京");
    }

    @RequestMapping("/insert")
    public Happiness insertService(){
        happinessService.insertService();
        return happinessService.selectService("西安");
    }
}

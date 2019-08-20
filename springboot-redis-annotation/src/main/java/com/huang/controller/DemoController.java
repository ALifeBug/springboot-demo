package com.huang.controller;

import com.huang.pojo.Address;
import com.huang.pojo.User;
import com.huang.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/findUser")
    public User findUser(){
        return demoService.findUser(1L,"huang","qingshan");
    }

    @RequestMapping("/updateUser")
    public User updateUser(){
        return demoService.updateUser(1L,"h","qs");
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(){
        demoService.deleteUser(1L);
        return "ok";
    }

    @RequestMapping("/findAddress")
    public Address findAddress(){
        return demoService.findAddress(1L,"anhui","hefei");
    }

}

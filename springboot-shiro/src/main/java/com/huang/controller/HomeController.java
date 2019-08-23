package com.huang.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        System.out.println("HomeController.login()");

        //登录失败从request中获取shiro处理的异常信息
        //shiroLoginFailure：就是shiro异常类的全类名
        String exception = (String)request.getAttribute("shiroLoginFailure");
        System.out.println("exception="+exception);
        String msg = "";
        if(exception!=null){
            if(UnknownAccountException.class.getName().equals(exception)){
                msg = "UnknownAccountException-->账户不存在";
                System.out.println(msg);
            }else if(IncorrectCredentialsException.class.getName().equals(exception)){
                msg = "IncorrectCredentialsException-->密码不正确";
                System.out.println(msg);
            }else if("kaptchValideFailed".equals(exception)){
                msg = "kaptchValidateFailed-->验证码错误";
                System.out.println(msg);
            }else {
                msg = "else >> "+exception;
                System.out.println(msg);
            }
        }
        map.put("msg",msg);
        //此方法不处理登录成功，由shiro处理
        return "/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("-------没有权限-------");
        return "403";
    }
}

package com.huang.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;


@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的链接，顺序判断
        filterChainDefinitionMap.put("/static/**","anon");
        //配置退出过滤器，其中的具体代码Shiro已经实现了
        filterChainDefinitionMap.put("/logout","logout");
        //过滤链定义，从上向下顺序执行，一般将/**放在最下边
        //authc:所有url都必须认证通过才可以访问,anon:所有url都可以匿名访问
        filterChainDefinitionMap.put("/**","authc");
        //如果不设置默认会自动寻找web工程目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     * 我们的密码校验交给shiro的SimpleAuthenticationInfo进行处理了
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法，这里使用md5算法
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于md5(md5(""))
        return hashedCredentialsMatcher;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }


    /**
     * 开启shiro aop注解支持
     * 使用代理方式
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException","databaseError");//数据库异常处理
        mappings.setProperty("UnauthorizedException","403");
        r.setExceptionMappings(mappings);
        r.setDefaultErrorView("error");
        r.setExceptionAttribute("ex");
        return r;
    }
}

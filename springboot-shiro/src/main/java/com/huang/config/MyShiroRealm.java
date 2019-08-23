package com.huang.config;

import com.huang.model.SysPermission;
import com.huang.model.SysRole;
import com.huang.model.UserInfo;
import com.huang.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;


    /**
     *权限配置
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal){
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo)principal.getPrimaryPrincipal();
        for(SysRole role : userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p : role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     *身份验证，也就是验证用户输入的账户和密码是否正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());

        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("--------->userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,//用户名
                userInfo.getPassword(),//密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName() //realm name
        );
        return authenticationInfo;
    }
}

package com.evan.my.Shiros;

import com.evan.my.entity.User;
import com.evan.my.service.UserService;
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

/**
 * @author mc
 * @create 2020-03-29 14:41
 **/
public class MCRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //重写获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        return s;
    }
//获取认证信息。即根据token 中的用户名从数据库中获取密码，盐等并返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName=token.getPrincipal().toString();
        User user=userService.getByname(userName);
        String passwordInDB=user.getPassword();
        String salt=user.getSalt();
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userName,passwordInDB, ByteSource.Util.bytes(salt),getName());
        return authenticationInfo;
    }
}

package com.gxa.realm;

import com.alibaba.druid.support.http.WebStatFilter;
import com.gxa.entity.Permission;
import com.gxa.entity.User;
import com.gxa.mapper.PermissionMapper;
import com.gxa.mapper.UserMapper;
import com.gxa.service.PermissionService;
import com.gxa.service.UserService;
import com.gxa.service.impl.UserServiceImpl;
import com.gxa.shirotoken.JwtToken;
import com.gxa.utils.JwtManage;
import jdk.nashorn.internal.parser.Token;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;
    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //在token中获取用户名
        //authenticationToken就是subject.login(token)传入的token
        //将authenticationToken 强转为UsernamePasswordToken
        UsernamePasswordToken token =  (UsernamePasswordToken)  authenticationToken;
        System.out.println(token.hashCode());
        //获取用户名
        String username = token.getUsername();
        System.out.println("=========username=====" + username);
        //根据用户名查找
        User user = userService.getByName(username);//数据中load的user
        System.out.println(user);
        String realm = getName();
        System.out.println(realm);
        ByteSource salt = ByteSource.Util.bytes(user.getName());
        System.out.println(salt);
//        if (JwtManage.verifyToken(username,user.getName(),user.getPwd())) {
//            System.out.println("登录成功");
//        } else {
//            throw new UnknownAccountException("用户名密码错误");
//        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(null,username, this.getName());
//        return simpleAuthenticationInfo;




            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPwd(),salt,realm);
            System.out.println("sdsfdsf");

            return simpleAuthenticationInfo;
    }
        //让shiro进行比对
        //参数1:返回数据库中正确的用户 principal
        //参数2:返回数据库中正确密码
        //参数3:提供当前realm的名字 this.getName();
             //return null;
//        public static void main(String[] args) {
//              String  hashAlgorithmName = "MD5";
//              Object credentials = "123";//明文 21232f297a57a5a743894a0e4a801fc3
//                // UUID uuid = UUID.randomUUID();
//                Object salt = ByteSource.Util.bytes("asuka");
//                System.out.println(salt);
//            Object result = new SimpleHash(hashAlgorithmName,credentials,salt,1024);
//            System.out.println(result);
//
//        }

    //}

    @Override
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从 principals获取主身份信息
        User principal = (User) principalCollection.getPrimaryPrincipal();
//        Set<String> perm = new HashSet<>();
//        System.out.println("principal="+principal);
//        if("admin".equals(principal)){
//            perm.add("emp:select");
//            perm.add("emp:del");
//            perm.add("emp:update");
//            perm.add("emp:add");
//        }else if("bb".equals(principal)){
//            perm.add("emp:select");
//            perm.add("emp:update");
//            perm.add("emp:add");
//        }else if("asuka".equals(principal)){
//            perm.add("emp:select");

//        }
        // 从数据库获取到权限数据
        Set<String> permissions = this.permissionService.queryPermissionByName(principal.getName());
        for (String p:permissions) {
            System.out.println(p);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.setStringPermissions(perm);
        //将权限名提供给info
        info.setStringPermissions(permissions);
        return info;

    }






}

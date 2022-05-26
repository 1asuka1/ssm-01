package com.gxa.controller;

import com.gxa.entity.User;
import com.gxa.service.UserService;
import com.gxa.shirotoken.JwtToken;
import com.gxa.utils.JwtManage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
//    @RequestMapping("/login")
//    public String login(User user, Map map, HttpSession session) {
//        System.out.println("name:--->" + user.getName());
//        System.out.println("pwd:--->" + user.getPwd());
//        User u = this.userService.login(user.getName(), user.getPwd());
//        if (u != null) {
//            session.setAttribute("user", u);
//            return "redirect:main.html";
//        }
//        map.put("error", "用户名或者密码不正确!");
//        return "index";
//    }
//
        @RequestMapping("/login")
        public String shiroLogin(User user, Map map, HttpSession session) {
            System.out.println("name:--->" + user.getName());
            System.out.println("pwd:--->" + user.getPwd());
            //拿到subject
            Subject subject = SecurityUtils.getSubject();
//            shiro生成token
            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPwd());
//            利用JWT生成token
//            String token = JwtManage.create(user.getName());

            System.out.println(token.hashCode());
            //异常处理
            try {
                subject.login(token);
                return "redirect:main.html";
            } catch (Exception e) {
               map.put("error", "登录失败用户不存在");
                return "index";

            }
        }

}


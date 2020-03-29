package com.evan.my.controller;

import com.evan.my.entity.User;
import com.evan.my.result.Result;
import com.evan.my.result.ResultFactory;
import com.evan.my.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


/**
 * @author mc
 * @create 2020-01-28 17:30
 **/
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    //登陆
    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        //对html标签进行转义，防止xss攻击
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
       usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String message = "帐号密码错误";
            return ResultFactory.buildFailResult(message);
        }
        //        username = HtmlUtils.htmlEscape(username);
//
//        User user = userService.get(username, requestUser.getPassword());
//        if (null == user) {
//            return new Result(400);
//        } else {
//            session.setAttribute("user", user);
//            return new Result(200);
//        }
    }

    //退出
    @GetMapping("/api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

    //注册
    @PostMapping("/api/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if (exist) {
            String messages = "用户名已被使用";
            return ResultFactory.buildFailResult(messages);
        }
        //生成盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置hash算法迭代次数
        int times = 2;
        //得到hash后的密码
        String encodefPassword = new SimpleHash("md5", password, salt, times).toString();
        //存储用户信息，包括salt与hash后的密码
        user.setSalt(salt);
        user.setPassword(encodefPassword);
        userService.add(user);
        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping("/api/authentication")
    public String authentication() {
        return "身份认证成功";
    }
}

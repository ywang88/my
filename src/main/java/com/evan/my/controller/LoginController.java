package com.evan.my.controller;

import com.evan.my.entity.User;
import com.evan.my.result.Result;
import com.evan.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @author mc
 * @create 2020-01-28 17:30
 **/
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        //对html标签进行转义，防止xss攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}

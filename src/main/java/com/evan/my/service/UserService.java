package com.evan.my.service;

import com.evan.my.dao.UserDAO;
import com.evan.my.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mc
 * @create 2020-01-28 19:31
 **/
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByname(username);
        return null != user;
    }

    //   根据用户名查询
    public User getByname(String username) {
        return userDAO.findByUsername(username);
    }

    //   根据用户名密码查询
    public User get(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }

    //添加用户
    public void add(User user) {
        userDAO.save(user);
    }
}

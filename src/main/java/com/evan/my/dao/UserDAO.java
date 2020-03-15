package com.evan.my.dao;

import com.evan.my.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mc
 * @create 2020-01-28 19:27
 **/
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);
}

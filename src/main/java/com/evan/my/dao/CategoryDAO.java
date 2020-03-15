package com.evan.my.dao;

import com.evan.my.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mc
 * @create 2020-03-15 12:19
 **/
public interface CategoryDAO extends JpaRepository<Category, Integer> {

}

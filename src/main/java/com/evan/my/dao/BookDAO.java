package com.evan.my.dao;

import com.evan.my.entity.Book;
import com.evan.my.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author mc
 * @create 2020-03-15 12:07
 **/
public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}

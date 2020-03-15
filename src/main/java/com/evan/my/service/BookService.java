package com.evan.my.service;

import com.evan.my.dao.BookDAO;
import com.evan.my.entity.Book;
import com.evan.my.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mc
 * @create 2020-03-15 12:29
 **/
@Service
public class BookService {
    @Autowired
     BookDAO bookDAO;

    @Autowired
    private CategoryService categoryService;

    //查出所有书籍
    public List<Book> list() {
        //根据id排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }

    //增加或更新书籍
    public void addupdate(Book book) {
        bookDAO.save(book);
    }

    //根据id删除书籍
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
    //通过分类查出书籍
    public List<Book> listByCategory(int cid){
        Category category=categoryService.get(cid);
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        return bookDAO.findAllByCategory(category);
    }
}
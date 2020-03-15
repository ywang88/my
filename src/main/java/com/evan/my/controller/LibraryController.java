package com.evan.my.controller;

import com.evan.my.entity.Book;
import com.evan.my.service.BookService;
import com.evan.my.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author mc
 * @create 2020-03-15 12:45
 **/
@RestController
public class LibraryController {

    @Autowired
   private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    //查出所有书籍
    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    //添加和修改书籍
    @CrossOrigin
    @PostMapping("/api/books")
    public Book addupdate(@RequestBody Book book) throws Exception {
        bookService.addupdate(book);
        return book;
    }

    //根据id删除书籍
    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    //根据书籍分类查出书籍
    @CrossOrigin
    @GetMapping("/api/categoryies/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception{
        if (0 !=cid){
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }

}

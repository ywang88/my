package com.evan.my.service;

import com.evan.my.dao.CategoryDAO;
import com.evan.my.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

/**
 * @author mc
 * @create 2020-03-15 12:22
 **/
@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    //查出所有并排序

    public List<Category> list() {
        //根据id排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    public Category get(int id) {
        Category category = categoryDAO.findById(id).orElse(null);
        return category;
    }
}

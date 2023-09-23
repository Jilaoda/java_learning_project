package com.blog.personalblog.service.impl;

import com.blog.personalblog.bo.CategoryBO;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.Category;
import com.blog.personalblog.service.CategoryService;
import com.blog.personalblog.mapper.CategoryMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-17 17:00:32
 * @description 文章分类服务实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryPage(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();     //获取查询的页码
        int pageSize = pageRequest.getPageSize();   //获取查询的条数
        PageHelper.startPage(pageNum,pageSize);    //开启分页
        List<Category> categoryList = categoryMapper.getCategoryPage();
        return categoryList;
    }

    @Override
    public int saveCategory(Category category) {
        return categoryMapper.create(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryMapper.delete(categoryId);
    }

    @Override
    public Category findById(Integer categoryId) {
        Category category = categoryMapper.getById(categoryId);
        return category;
    }

    @Override
    public List<Category> getCategoriesByName(CategoryBO bo) {
        List<Category> categoriesByName = categoryMapper.findCategoriesByName(bo);
        return categoriesByName;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        Category category = categoryMapper.getCategoryByName(categoryName);
        return category;
    }

}
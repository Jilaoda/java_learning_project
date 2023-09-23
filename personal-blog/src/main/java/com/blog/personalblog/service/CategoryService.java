package com.blog.personalblog.service;

import com.blog.personalblog.bo.CategoryBO;
import com.blog.personalblog.config.page.PageRequest;
import com.blog.personalblog.entity.Category;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-17 17:00:03
 * @description 分页查询接口
 */
public interface CategoryService {

     /**
     * @details: 获取所有的分类（分页）
     * @date: 2023/5/17
     * @Param: [pageRequest]
     * @return: java.util.List<com.blog.personalblog.entity.Category>
     */
    List<Category> getCategoryPage(PageRequest pageRequest);

    /**
     * @details: 保存分类
     * @date: 2023/5/17
     * @Param: [category]
     * @return: int
     */
    int saveCategory(Category category);

    /**
     * @details: 更新分类
     * @date: 2023/5/17
     * @Param: [category]
     * @return: int
     */
    int updateCategory(Category category);

    /**
     * @details: 删除分类
     * @date: 2023/5/17
     * @Param: [categoryId]
     * @return: void
     */
    void deleteCategory(Integer categoryId);

    /**
     * @details: 根据分类id查找分类
     * @date: 2023/5/17
     * @Param: [categoryId]
     * @return: com.blog.personalblog.entity.Category
     */
    Category findById(Integer categoryId);

    /**
     * 搜索文章分类
     * @param bo
     * @return
     */
    List<Category> getCategoriesByName(CategoryBO bo);

    /**
     * 获取分类
     * @param categoryName
     * @return
     */
    Category getCategoryByName(String categoryName);

}
package com.blog.personalblog.mapper;

import com.blog.personalblog.bo.CategoryBO;
import com.blog.personalblog.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-17 16:55:11
 * @description  博客分类数据接口
 */
@Repository
public interface CategoryMapper {

    /**
     * @details: 创建
     * @date: 2023/5/17
     * @Param: [category]
     * @return: int
     */
    int create(Category category);

    /**
     * @details: 修改
     * @date: 2023/5/17
     * @Param: [category]
     * @return: int
     */
    int update(Category category);

    /**
     * @details: 分类列表（分页）
     * @date: 2023/5/17
     * @Param: []
     * @return: java.util.List<com.blog.personalblog.entity.Category>
     */
    List<Category> getCategoryPage();


    /**
     * @details: 删除
     * @date: 2023/5/17
     * @Param: [id]
     * @return: void
     */
    void delete(Integer id);

    /**
     * @details: 根据id查询
     * @date: 2023/5/17
     * @Param: [id]
     * @return: com.blog.personalblog.entity.Category
     */
    Category getById(Integer id);

    /**
     * 查询分类
     * @param bo
     * @return
     */
    List<Category> findCategoriesByName(CategoryBO bo);

    Category getCategoryByName(String categoryName);

}
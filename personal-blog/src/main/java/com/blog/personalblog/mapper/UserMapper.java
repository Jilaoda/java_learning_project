package com.blog.personalblog.mapper;

import com.blog.personalblog.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author liweiliang
 * @create 2023-05-09 21:40:24
 * @description 实现对用户的增删改查
 */
@Repository // Spring的注解,用来标识当前类是一个bean
public interface UserMapper {

    /**
     * @details: 查询所有用户信息
     * @date: 2023/5/10
     * @Param: []
     * @return: java.util.List<com.blog.personalblog.entity.User>
     */
    List<User> findAll();

     /**
     * @details: 添加用户
     * @date: 2023/5/10
     * @Param: [user]
     * @return: void
     */
    void insert(User user);

    /**
     * @details: 更新用户
     * @date: 2023/5/10
     * @Param: [user]
     * @return: void
     */
    void update(User user);

    /**
     * @details: 删除用户
     * @date: 2023/5/10
     * @Param: [id]
     * @return: int
     */
    int delete(int id);

    /**
     * @details: 根据用户id查找用户
     * @date: 2023/5/28
     * @Param: [userId]
     * @return: com.blog.personalblog.entity.User
     */
    User findByUserId(Integer userId);

    /**
     * username
     * @param userName
     * @return
     */
    User findByUsername(String userName);

    /**
     * 更新上次登录时间
     * @param user
     */
    void updateById(User user);

}
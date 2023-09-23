package com.blog.personalblog.service;



import com.blog.personalblog.entity.User;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-09 21:40:33
 * @description  用户服务接口
 */
public interface UserService {

    /**
     * @details: 查询所有用户列表
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
    void createUser(User user);

    /**
     * @details: 修改用户信息
     * @date: 2023/5/10
     * @Param: [user]
     * @return: void
     */
    void updateUser(User user);


    /**
     * @details: 删除用户
     * @date: 2023/5/10
     * @Param: [id]
     * @return: void
     */
    void deleteUser(int id);

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
    User getUserByUserName(String userName);

    /**
     * 更新上次登录时间
     * @param userId
     */
    void updateLoginTime(Integer userId);

}


package com.blog.personalblog.service.impl;

import com.blog.personalblog.entity.User;
import com.blog.personalblog.service.UserService;
import com.blog.personalblog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-09 21:40:43
 * @description 用户服务类实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired //自动注入UserMapper的bean对象
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> userList;
        userList = userMapper.findAll();
        return userList;
    }

    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.delete(id);
    }

    @Override
    public User findByUserId(Integer userId) {
        User user = userMapper.findByUserId(userId);
        return user;
    }
    @Override
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        User user = userMapper.findByUsername(userName);
        return user;
    }
    @Override
    public void updateLoginTime(Integer userId) {
        User user = new User();
        user.setId(userId);
        user.setLastLoginTime(LocalDateTime.now());
        userMapper.updateById(user);
    }


}

package com.shaoshuai.myblog.service.impl;

import com.shaoshuai.myblog.entity.Tuser;
import com.shaoshuai.myblog.entity.User;
import com.shaoshuai.myblog.mapper.UserMapper;
import com.shaoshuai.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/221:10
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Cacheable(cacheNames = {"user"})
    @Override
    public Map getUserById(Integer id) {
        return userMapper.getUserById(id);
    }


    @Cacheable(cacheNames = {"user2"})
    @Override
    public Tuser getTuserById(Integer id) {
        return userMapper.getTuserById(id);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public String selectAsaltByName(String name) {
        return userMapper.selectAsaltByName(name);
    }

    @Override
    public int userRegister(User user) {
        return userMapper.userRegister(user);
    }

    @Override
    public User selectOneUserByName(String username) {
        return userMapper.selectOneUserByName(username);
    }
}

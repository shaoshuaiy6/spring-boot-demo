package com.shaoshuai.myblog.service;

import com.shaoshuai.myblog.entity.Tuser;
import com.shaoshuai.myblog.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/221:09
 * @Version 1.0
 **/
public interface UserService {

    public Map getUserById(Integer id);

    public Tuser getTuserById(Integer id);

    /**
     * 查询所有用户的所有信息
     * @return
     */
    List<User> selectAllUser();

    /**
     * 根据用户名查询一个用户的所有信息
     * @param username
     * @return
     */
    User selectOneUserByName(String username);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int userRegister(User user);

    /**
     * 根据用户名查询这个用户的盐值
     * @param name
     * @return
     */
    String selectAsaltByName(String name);
}

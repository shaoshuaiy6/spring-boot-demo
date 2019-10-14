package com.shaoshuai.myblog.mapper;

import com.shaoshuai.myblog.entity.Tuser;
import com.shaoshuai.myblog.entity.User;

import java.util.List;
import java.util.Map;
/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/216:58
 * @Version 1.0
 **/
public interface UserMapper {

    public Map getUserById(Integer id);

    Tuser getTuserById(Integer id);

    String selectAsaltByName(String name);

    int userRegister(User user);

    User selectOneUserByName(String username);

    List<User> selectAllUser();

}

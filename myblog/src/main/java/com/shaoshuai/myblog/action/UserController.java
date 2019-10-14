package com.shaoshuai.myblog.action;

import com.shaoshuai.myblog.entity.User;
import com.shaoshuai.myblog.service.UserService;
import com.shaoshuai.myblog.util.UserRegisteAndLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/620:32
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    private UserService service;

    /**
     * 处理用户的登录请求
     */
    @PostMapping("/userLogin")
    public String userLogin(User user, Model model)
    {
        user.setPassword(UserRegisteAndLogin.getInputPasswordCiph(user.getPassword(), service.selectAsaltByName(user.getName())));

        return UserRegisteAndLogin.userLogin(user, model);
    }

    /**
     * 处理用户的注册请求
     * @param user
     * @return
     */
    @PostMapping("/userRegister")
    public String userRegister(User user, Model model)
    {
        String userName = user.getName();
        String password = user.getPassword();

        String[] saltAndCiphertext = UserRegisteAndLogin.encryptPassword(password);

        user.setSalt(saltAndCiphertext[0]);
        user.setPassword(saltAndCiphertext[1]);

        service.userRegister(user);

        return UserRegisteAndLogin.userLogin(user, model); //使用户沆注册后立马登录
    }
}

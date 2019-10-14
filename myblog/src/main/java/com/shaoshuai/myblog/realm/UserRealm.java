package com.shaoshuai.myblog.realm;

/**
 * @ClassName UserRealm
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/620:34
 * @Version 1.0
 **/
import com.shaoshuai.myblog.entity.User;
import com.shaoshuai.myblog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm
{
    @Autowired
    private UserService userService;

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken; //获得用户输入的用户名,这个对象就是login()传递过来的，将它强转以取出封装的用户名
        String userNameInput = token.getUsername();

        User selectUser = userService.selectOneUserByName(userNameInput);

        if(selectUser == null) //用户不存在，返回null
        {
            return null;
        }

        return new SimpleAuthenticationInfo(selectUser, selectUser.getPassword(), "");
    }

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
    {
        Subject subject = SecurityUtils.getSubject(); //获得一个Subject对象
        User user = (User) subject.getPrincipal(); //获得登录的对象

        String str = user.getPer(); //获得登录对象的权限字符串

        if(str==null || str.isEmpty())
        {
            str = "noAnyAuth";
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); //创建一个这样的对象，它是返回的类型的子类
        info.addStringPermission(str); //添加权限，这个方法的参数字符串如果为 null或"" 会抛出异常

        return info;
    }
}


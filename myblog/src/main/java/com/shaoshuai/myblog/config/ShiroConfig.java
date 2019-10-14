package com.shaoshuai.myblog.config;

import com.shaoshuai.myblog.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/620:40
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig
{
    /**
     * 这个方法关联一个安全管理器
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager); //关联安全管理器

        /**
         * 设置拦截URL
         */
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/resouces/a", "authc");
        map.put("/resouces/b", "perms[get:b]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        shiroFilterFactoryBean.setLoginUrl("/toPage/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/resouces/haveNoPer");

        return  shiroFilterFactoryBean;
    }

    /**
     * 获得一个安全管理器
     * 这个方法关联一个realm类
     * @param userRealm
     * @return
     */
    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") UserRealm userRealm)
    {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm); //设置realm

        return manager;
    }

    /**
     * 获得一个realm类
     * @return
     */
    @Bean(name = "realm")
    public UserRealm getRealm()
    {
        return new UserRealm();
    }

//    @Bean(name = "shiroDialect")
//    public ShiroDialect getShiroDialect()
//    {
//        return new ShiroDialect();
//    }
}
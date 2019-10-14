package com.shaoshuai.myblog;

import com.shaoshuai.myblog.filter.JwtFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description @ImportResource:导入Spring的配置文件，让配置文件里面的内容生效；Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
 * 想让Spring的配置文件生效，加载进来； @ImportResource标注在一个配置类上
 *
 * 日志:
 * 日志门面：SLF4j,JCL,jboss-logging
 * 日志实现: Logback,Log4j,Log4j2,JUl
 * SpringBoot：底层是Spring框架，Spring框架默认是用JCL;
 * SpringBoot选用SLF4j和Logback
 *
 * @EnableAsync 开启异步注解
 * @EnableScheduling 开启定时任务注解
 *
 * @ClassName MyBlogMainApplication
 * @Author Mr. Shao
 * @Date 2019/10/113:02
 * @Version 1.0
 **/
//@ImportResource(locations = {"classpath:config/beans.xml"})
@MapperScan(basePackages ={"com.shaoshuai.myblog.mapper"})
@EnableCaching
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class MyBlogMainApplication {
    public static void main(String[] args){
        SpringApplication.run(MyBlogMainApplication.class,args);
        System.out.println("MyBlogMainApplication SpringBoot run success!");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtFilter jwtFilter = new JwtFilter();
        registrationBean.setFilter(jwtFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/home/*");
        urlPatterns.add("/helloName");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}

package com.shaoshuai.myblog;

import com.shaoshuai.myblog.entity.Tuser;
import com.shaoshuai.myblog.service.UserService;
import com.shaoshuai.myblog.util.LogUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SpringBootConfigApplicationTests
 * @Description SpringBoot单元测试
 * 可以在测试期间很方便
 * @Author Mr. Shao
 * @Date 2019/10/112:41
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyBlogMainApplication.class})// 指定启动类
public class SpringBootConfigApplicationTests {
    //    @Autowired
//    ApplicationContext ioc;
    @Autowired
    DataSource dataSource;
    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象的
    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串的
    @Autowired
    UserService userService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    JavaMailSenderImpl mailSender;


//    @Test
//    public void testHelloWorld(){
//      boolean b = ioc.containsBean("helloService");
//      System.out.println(b);
//    }

    @Test
    public void testLog4j2() {
        LogUtil.error("测试日志");
    }

    @Test
    public void contextLoads2() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    /**
     * Redis常见的五大数据类型
     * String(字符串)、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     */
    @Test
    public void testRedis() {
//        stringRedisTemplate.opsForValue().append("msg","hello");
        Tuser tuser = userService.getTuserById(1);
        redisTemplate.opsForValue().set("tUser", tuser);
    }

    /**
     * 测试RabbitMQ
     * 1.单播（点对点）
     */
    @Test
    public void testRabbitMq() {
        //Message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routingKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq;
        //rabbitTemplate.convertAndSend(exchange,routingKey,object);
        Map<String, Object> map = new HashMap<>(2);
        map.put("msg", "这是第一个消息!");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("exchanges.direct", "shaoshuaiblog.news", map);
    }

    /**
     * 接收消息
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("shaoshuaiblog.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchanges.fanout", "", "测试广播消息发送");
    }

    /**
     * 测试发送邮件
     */
    @Test
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-今晚开会");
        message.setText("今晚7：30开会");
        message.setFrom("610357632@qq.com");
        message.setTo("610357632@qq.com");
        mailSender.send(message);
    }

}


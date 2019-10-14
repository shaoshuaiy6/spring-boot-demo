package com.shaoshuai.myblog.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ClassName HelloService
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/114:09
 * @Version 1.0
 **/
@Service
public class HelloService {

    /**
     *   @Async 注解标识改方法进行异步处理
     */
    @Async
    public void sayHello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中.....");
    }
}

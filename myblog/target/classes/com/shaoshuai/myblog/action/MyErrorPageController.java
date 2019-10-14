package com.shaoshuai.myblog.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MyErrorPageController
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/714:24
 * @Version 1.0
 **/
@Controller
public class MyErrorPageController {
    @RequestMapping("error-404")
    public String toPage404(){
        return "/error/error-404.html";
    }
    @RequestMapping("error-400")
    public String toPage400(){
        return "/error/error-400.html";
    }
    @RequestMapping("error-500")
    public String toPage500(){
        return "/error/error-500.html";
    }
}

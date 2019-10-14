package com.shaoshuai.myblog.action;

import com.shaoshuai.myblog.entity.User;
import com.shaoshuai.myblog.util.LogUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CommonController
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/620:42
 * @Version 1.0
 **/
@Controller
public class CommonController {


    /**
     * 设置首页
     * @return
     */
    @GetMapping("/")
    public String indexPage(Model model)
    {
        try
        {
            String a=null;
            a.getBytes();
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            model.addAttribute("user_name",user.getName());
            if(StringUtils.isEmpty(user.getName())){
                model.addAttribute("user_name","test");
             }
        }
        catch (NullPointerException e)
        {
            //空指针异常，没有用户登录
            LogUtil.error(""+e.getMessage());
            throw new NullPointerException("系统出现异常");
        }

        return "/user/index.html";
    }

    @GetMapping("/toPage/{page}")
    public String pageJump(@PathVariable(name = "page") String page)
    {
        return "/user/"+page+".html";
    }

    @GetMapping("/404")
    public String to404(){
        return "/error/error-404.html";
    }

    @RequestMapping(value = "/mul")
    public int mulParam(int param) {
        return 9/param;
    }
}

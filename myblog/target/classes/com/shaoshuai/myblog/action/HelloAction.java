package com.shaoshuai.myblog.action;

import com.shaoshuai.myblog.entity.Tuser;
import com.shaoshuai.myblog.service.HelloService;
import com.shaoshuai.myblog.service.UserService;
import com.shaoshuai.myblog.util.JWTUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName HelloAction
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/110:16
 * @Version 1.0
 **/
@Controller
public class HelloAction {
    @Autowired
    UserService userService;
    @Autowired
    HelloService helloService;
    @Autowired
    private JWTUtil jwtUtil;

    @ResponseBody
    @RequestMapping("/getJwtToken")
    public String getJwtToken() {
        return jwtUtil.creatJwtToken();
    }

    //url过滤/home/*，调用会执行filter
    @RequestMapping(value = "/home/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String homePage() {
        return "Welcome to home page.";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String helloWorld(@RequestParam("name") String name) {
        return "Result:".concat(name);
    }

    @RequestMapping("/success")
    public String success() {
        return "/success.html";
    }

    @ResponseBody
    @RequestMapping("/getUserById")
    public Map getUserById(Integer id) {
        return userService.getUserById(id);
    }

    @ResponseBody
    @RequestMapping("/getTuserById")
    public Tuser getTuserById(Integer id) {
        return userService.getTuserById(id);
    }

    @GetMapping("/helloName")
    String testHelloName(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("name", "java");
        return "/user/hello.html";
    }

    @ResponseBody
    @RequestMapping("sayHello")
    public String sayHello() {
        helloService.sayHello();
        return "/success.html";
    }

    @ResponseBody
    @RequestMapping("device")
    public String detectDevice(HttpServletRequest request, HttpServletResponse response) {
        String requestHeader=request.getHeader("user-agent");
//        Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
//        Matcher matcher = pattern.matcher(userAgent);
//        String model = null;
//        if (matcher.find()) {
//            model = matcher.group(1).trim();
//            System.out.println("通过userAgent解析出机型：" + model);
//        }
        // 获取session对象
        HttpSession session = request.getSession();
        // 重写cookie返回给浏览器
                Cookie cookie = new Cookie("JSESSIONID", session.getId());
        // 设置有效期，时间为秒
                cookie.setMaxAge(30 * 60);
        // 设置path
                cookie.setPath("/");
        // 加入到response对象中
                response.addCookie(cookie);
        //解析agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(requestHeader);
         //获取浏览器对象
        Browser browser = userAgent.getBrowser();
        //获取操作系统对象
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        System.out.println("agent:"+requestHeader);
        System.out.println("浏览器名:"+browser.getName());
        System.out.println("浏览器类型:"+browser.getBrowserType());
        System.out.println("浏览器家族:"+browser.getGroup());
        System.out.println("浏览器生产厂商:"+browser.getManufacturer());
        System.out.println("浏览器使用的渲染引擎:"+browser.getRenderingEngine());
        System.out.println("浏览器版本:"+userAgent.getBrowserVersion());


        System.out.println("\n操作系统名:"+operatingSystem.getName());
        System.out.println("访问设备类型:"+operatingSystem.getDeviceType());
        System.out.println("操作系统家族:"+operatingSystem.getGroup());
        System.out.println("操作系统生产厂商:"+operatingSystem.getManufacturer());
        LiteDeviceResolver deviceResolver = new LiteDeviceResolver();
        Device device = deviceResolver.resolveDevice(request);
        System.out.println(device.isMobile());
        return device.toString();
    }
}

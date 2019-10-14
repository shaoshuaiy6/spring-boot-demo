package com.shaoshuai.myblog.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
/**
 * @ClassName DruidStatFilter
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/216:29
 * @Version 1.0
 **/
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
})
public class DruidStatFilter extends WebStatFilter {
}
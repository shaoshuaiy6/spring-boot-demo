package com.shaoshuai.myblog.config;

import org.apache.commons.lang.math.RandomUtils;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * @ClassName BeetlConfiguration
 * @Description  beetl拓展配置, 绑定一些工具类, 方便在模板中直接调用.直接配置groupTemplate
 * @Author Mr. Shao
 * @Date 2019/10/712:37
 * @Version 1.0
 **/
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {
    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("random", new RandomUtils());
    }
}

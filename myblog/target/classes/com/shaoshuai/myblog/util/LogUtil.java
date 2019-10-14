package com.shaoshuai.myblog.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName LogUtil
 * @Description TODO  日志辅助工具类
 * @Author Mr. Shao
 * @Date 2019/10/211:26
 * @Version 1.0
 **/
public class LogUtil {
    private static final Logger LOGGER = LogManager.getLogger();

    private LogUtil(){
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static Logger getLogger(){
        return LOGGER;
    }

    public static void trace(String msg){
        LOGGER.trace(msg);
    }

    public static void debug(String msg){
        LOGGER.debug(msg);
    }

    public static void info(String msg){
        LOGGER.info(msg);
    }

    public static void warn(String msg){
        LOGGER.warn(msg);
    }

    public static void error(String msg){
        LOGGER.error(msg);
    }
}

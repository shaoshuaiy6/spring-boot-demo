package com.shaoshuai.myblog.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScheduledService
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/48:18
 * @Version 1.0
 **/
@Service
public class ScheduledService {

    /**
     * @Scheduled 注解标识方法进行定时任务
     * second(秒),minute（分）, hour（时）, day of month（日）, month（月）, day of week(周几)
     * "0 * * * * MON-FRI"
     * 用法：
     * 字段	        允许值	                允许的特殊字符
     * 秒	        0-59	                 , - * /
     * 分	        0-59	                 , - * /
     * 小时	        0-23	                 , - * /
     * 日期	        1-31	                 , - * ? / L W C
     * 月份	        1-12 或者 JAN-DEC	     , - * /
     * 星期	        1-7 或者 SUN-SAT	     , - * ? / L C #
     * 年（可为空）	留空, 1970-2099	         , - * /
     * （1）* 表示可以匹配该域的所有值；
     * （2）？在cron表达式中必须出现且只能出现1次，用在日域或周域上，表示不确定值、不限制值；
     * （3）- 表示匹配该域上的一个范围；
     * （4）, 表示枚举值；
     * （5）/ 表示起始时间和间隔时间；
     * （6）# 只能用于周域上，#后面的数字表示第几周，如果不存在这个周的值，则不执行；
     * （7）L 只能用于日域或周域，用于日域时表示当月最后一天，用于周域如果前面不加数字表示周六，加数字表示最后一个周值；
     *   详细用法见地址:https://blog.csdn.net/wh13267207590/article/details/80095128
     */
    @Scheduled(cron = "1 * * * * MON-FRI")
    public void testScheduled(){
        System.out.println("定时任务处理....");
    }
}

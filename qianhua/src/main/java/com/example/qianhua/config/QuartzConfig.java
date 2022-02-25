package com.example.qianhua.config;

import com.example.qianhua.task.TaskTest;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail getMyTaskJobDetail(){
        return JobBuilder.newJob(TaskTest.class)
                .withIdentity("myJobTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger myTaskJobTrigger(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(getMyTaskJobDetail())
                .withIdentity("myJobTaskTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}

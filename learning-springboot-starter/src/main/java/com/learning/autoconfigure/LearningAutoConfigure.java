package com.learning.autoconfigure;

import com.learning.service.UserService;
import com.learning.service.impl.ShushengxiangUserService;
import com.learning.service.impl.XiaowangUserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 11:06
 **/
@Configuration
public class LearningAutoConfigure {

    @Bean
    @ConditionalOnProperty(prefix = "user", value = "shushengxiang", havingValue = "true")
    public UserService getShushengxiangUserService(){
        return new ShushengxiangUserService();
    }

    @Bean
    @ConditionalOnProperty(prefix = "user", value = "xiaowang", havingValue = "true")
    public UserService getUserService(){
        return new XiaowangUserService();
    }

}

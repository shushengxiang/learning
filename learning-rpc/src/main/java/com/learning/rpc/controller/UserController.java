package com.learning.rpc.controller;

import com.learning.rpc.factory.MyFactoryBean;
import com.learning.rpc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 17:55
 **/
@Configuration
@RestController
public class UserController {

    @Autowired
//    @Qualifier(value = "com.learning.rpc.service.UserService")
    private UserService userService;


//    @Bean
//    public UserService getMyFactoryBean() throws Exception {
//       return new MyFactoryBean<UserService>(UserService.class).getObject();
//    }


    @GetMapping("/v1/user/{id}")
    public Map<String,Object> getUser(@PathVariable Long id){
        Map<String,Object> result = new HashMap<>();
        result.put("result",userService.queryName(id));
        return result;
    }

}

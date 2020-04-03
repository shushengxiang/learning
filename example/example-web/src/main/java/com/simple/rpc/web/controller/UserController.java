package com.simple.rpc.web.controller;

import com.simple.rpc.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 11:50
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/v1/user")
    public String get(){
        return userService.queryName(0L);
    }

}

package com.learning.autoconfigure.controller;

import com.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 14:24
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/v1/user")
    public Object getUser(){
        return userService.queryName(1L);
    }

}

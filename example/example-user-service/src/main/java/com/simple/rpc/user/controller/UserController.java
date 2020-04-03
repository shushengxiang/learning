package com.simple.rpc.user.controller;

import com.simple.rpc.common.model.RPCResponse;
import com.simple.rpc.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 10:24
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/v1/user")
    public RPCResponse<String> get(){
        return RPCResponse.success(userService.queryName(null));
    }

}

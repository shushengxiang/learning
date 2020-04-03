package com.simple.rpc.user.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 12:25
 **/
@Service
public class UserService implements com.simple.rpc.user.api.UserService {
    @Override
    public String queryName(Long id) {
        return "shushengxiang";
    }
}

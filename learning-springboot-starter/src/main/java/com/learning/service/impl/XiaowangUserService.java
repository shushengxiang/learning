package com.learning.service.impl;

import com.learning.service.UserService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 14:29
 **/
@Slf4j
public class XiaowangUserService implements UserService {

    @Override
    public String queryName(Long id) {
        log.info("Receive one invoke by queryName use XiaowangUserService");
        return "xiaowang";
    }
}

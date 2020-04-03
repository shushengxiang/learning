package com.simple.rpc.user.api;

import com.simple.rpc.common.annotation.SimpleRPCClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 10:21
 **/
@SimpleRPCClient("user")
public interface UserService {

    @RequestMapping("/v1/user")
    String queryName(Long id);

}

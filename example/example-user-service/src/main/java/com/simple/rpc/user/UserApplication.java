package com.simple.rpc.user;

import com.simple.rpc.server.annotation.EnableSimpleRPCServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 10:23
 **/
@EnableSimpleRPCServer("com.simple.rpc.user.api")
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }

}

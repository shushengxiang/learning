package com.simple.rpc.web;

import com.simple.rpc.client.annotation.EnableSimpleRPC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 11:48
 **/
@SpringBootApplication
@EnableSimpleRPC("com.simple.rpc.user.api")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }

}

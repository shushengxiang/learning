package com.learning.rpc;

import com.learning.rpc.annotation.EnableRPC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 17:57
 **/
@ComponentScan
@EnableRPC
@SpringBootApplication
public class RPCApplication {

    public static void main(String[] args) {
        SpringApplication.run(RPCApplication.class, args);
    }
}

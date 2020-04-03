package com.simple.rpc.server.config;

import com.simple.rpc.common.condition.HttpCondition;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import com.simple.rpc.server.registry.ServerRegistry;
import com.simple.rpc.server.starter.SimpleRPCServerStarter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 10:27
 **/
@Configuration
@EnableConfigurationProperties(SimpleRPCServerProperties.class)
public class SimpleRPCServerConfig {

    @Bean
    @Conditional(HttpCondition.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean(initMethod = "init")
    @Conditional(HttpCondition.class)
    public SimpleRPCServerStarter simpleRPCServerStarter(ServerRegistry serverRegistry){
        return new SimpleRPCServerStarter(serverRegistry);
    }


}

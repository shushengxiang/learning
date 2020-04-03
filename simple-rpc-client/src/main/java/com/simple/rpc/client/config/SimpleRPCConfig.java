package com.simple.rpc.client.config;

import com.simple.rpc.client.condition.HttpCondition;
import com.simple.rpc.client.discovery.Discovery;
import com.simple.rpc.client.discovery.impl.DefaultSimpleDiscovery;
import com.simple.rpc.client.invoke.impl.HttpInvoker;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 17:22
 **/
@Configuration
@EnableConfigurationProperties(SimpleRPCServerProperties.class)
public class SimpleRPCConfig {

    @Bean
    @Conditional(HttpCondition.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @Conditional(HttpCondition.class)
    public HttpInvoker getHttpInvoker(RestTemplate restTemplate){
        return new HttpInvoker(restTemplate);
    }

    @Bean
    public Discovery discovery(RestTemplate restTemplate,
                               SimpleRPCServerProperties rpcServerProperties){
        return new DefaultSimpleDiscovery(restTemplate,rpcServerProperties);
    }

}

package com.simple.rpc.server.registry;

import com.alibaba.fastjson.JSON;
import com.simple.rpc.common.model.Response;
import com.simple.rpc.common.model.ServerMetadata;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 17:19
 **/
@Configuration
@EnableConfigurationProperties(SimpleRPCServerProperties.class)
public class AutoHttpServerRegistrationConfiguration {

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.name}")
    private String serverName;

    @Autowired
    private SimpleRPCServerProperties simpleRPCServerProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @PostConstruct
    public void init(){
        StringBuilder addServerUrl =
                new StringBuilder(simpleRPCServerProperties.getLeaderHost()).append("/v1/server");

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("name", serverName);
        request.add("address", serverPort);

        restTemplate.postForObject(addServerUrl.toString(), request , Response.class);
    }

}

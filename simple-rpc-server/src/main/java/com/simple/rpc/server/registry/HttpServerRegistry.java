package com.simple.rpc.server.registry;

import com.simple.rpc.common.model.Response;
import com.simple.rpc.common.model.ServerMetadata;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 11:11
 **/
@Slf4j
public class HttpServerRegistry extends AbstractServerRegistry {

    @Value("${server.port}")
    private String port;

    @Autowired
    private SimpleRPCServerProperties simpleRPCServerProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void register(ServerMetadata serverMetadata) {
        StringBuilder addServerUrl =
                new StringBuilder(simpleRPCServerProperties.getLeaderHost()).append("/v1/server");

        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("name", serverMetadata.getName());
        request.add("address", port);

        restTemplate.postForObject(addServerUrl.toString(), request , Response.class);
    }
}

package com.simple.rpc.client.discovery.impl;

import com.alibaba.fastjson.JSON;
import com.simple.rpc.client.discovery.Discovery;
import com.simple.rpc.common.model.DataResponse;
import com.simple.rpc.common.model.ServerMetadata;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 15:38
 **/
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class DefaultSimpleDiscovery implements Discovery {

    RestTemplate restTemplate;

    SimpleRPCServerProperties simpleRPCServerProperties;

    @Override
    public Map discover() {
        StringBuilder serversUrl = new StringBuilder();
        serversUrl.append(simpleRPCServerProperties.getLeaderHost()).append("/v1/servers");

        DataResponse servers =
                restTemplate.getForObject(serversUrl.toString(), DataResponse.class);

        return  (Map)servers.getData();
    }

    @Override
    public List<ServerMetadata> get(String serverName) {
        Object key = discover().get(serverName);
        return JSON.parseArray(JSON.toJSONString(key),ServerMetadata.class);
    }
}

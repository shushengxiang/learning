package com.simple.rpc.client.invoke.impl;

import com.simple.rpc.client.invoke.Invoker;
import com.simple.rpc.common.model.RPCRequest;
import com.simple.rpc.common.model.RPCResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:55
 **/
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class HttpInvoker implements Invoker {

    private RestTemplate restTemplate;

    @Override
    public RPCResponse invoke(RPCRequest request) {
        RequestMapping requestMapping = request.getMethod().getAnnotation(RequestMapping.class);
        String path = requestMapping.value()[0];
        RPCResponse response = restTemplate.getForObject(
                new StringBuilder().append("http://localhost:").append(request.getServerMetadata().getAddress())
                        .append("/").append(path).toString(), RPCResponse.class);

        log.info("response is {}",response);
        return response;
    }

}

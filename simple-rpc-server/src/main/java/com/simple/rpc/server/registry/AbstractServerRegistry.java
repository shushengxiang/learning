package com.simple.rpc.server.registry;

import com.simple.rpc.common.model.ServerMetadata;
import com.simple.rpc.common.properties.SimpleRPCServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 11:06
 **/
public abstract class AbstractServerRegistry implements ServerRegistry{

    @Autowired
    private SimpleRPCServerProperties simpleRPCServerProperties;

    @Override
    public void register() {
        register(ServerMetadata.builder().name(simpleRPCServerProperties.getName())
                .address(simpleRPCServerProperties.getPort()).build());
    }

    public abstract void register(ServerMetadata serverMetadata);
}

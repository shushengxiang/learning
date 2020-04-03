package com.simple.rpc.server.starter;

import com.simple.rpc.server.registry.ServerRegistry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/3 11:40
 **/
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class SimpleRPCServerStarter {

    private ServerRegistry serverRegistry;

    public void init(){
        log.info("Start SimpleRPCServerStarter init");
        serverRegistry.register();
    }

}

package com.simple.rpc.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 15:29
 **/
@Data
@ConfigurationProperties(prefix = "simple.rpc.server")
public class SimpleRPCServerProperties {

    private String leaderHost;

    private String name;

    private String port;

}

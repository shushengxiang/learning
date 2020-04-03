package com.simple.rpc.client.loadbalance;

import com.simple.rpc.common.model.ServerMetadata;

import java.util.List;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:41
 **/
public class RandomLoadBalance implements LoadBalance {

    @Override
    public ServerMetadata get(List<ServerMetadata> serverMetadataList) {
        return serverMetadataList.get(0);
    }
}

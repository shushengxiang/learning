package com.simple.rpc.client.loadbalance;

import com.simple.rpc.common.model.ServerMetadata;

import java.util.List;

public interface LoadBalance {

    ServerMetadata get(List<ServerMetadata> serverMetadataList);

}

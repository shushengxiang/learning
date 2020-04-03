package com.simple.rpc.client.discovery;

import com.simple.rpc.common.model.ServerMetadata;

import java.util.List;
import java.util.Map;

public interface Discovery {

    /**
     * discover all servers
     * @return
     */
    Map discover();



    List<ServerMetadata> get(String serverName);

}

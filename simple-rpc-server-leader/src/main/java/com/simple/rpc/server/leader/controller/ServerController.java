package com.simple.rpc.server.leader.controller;

import com.simple.rpc.common.model.DataResponse;
import com.simple.rpc.common.model.Response;
import com.simple.rpc.common.model.ServerMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/1 14:47
 **/
@Slf4j
@RestController
@RequestMapping("/v1")
public class ServerController {

    // these are the http servers
    Map<String,List<ServerMetadata>> servers = new ConcurrentHashMap<>();

    @GetMapping("/servers")
    public DataResponse<Map<String,List<ServerMetadata>>> getHttpServers(){
        return DataResponse.success(servers);
    }

    @PostMapping("/server")
    public Response addServer(ServerMetadata serverMetadata){
        if (servers.containsKey(serverMetadata.getName())){
            servers.get(serverMetadata.getName()).add(serverMetadata);
        }else {
            List<ServerMetadata> serverMetadataList = new ArrayList<>();
            serverMetadataList.add(serverMetadata);
            servers.put(serverMetadata.getName(),serverMetadataList);
        }
        log.info("Add a new server, server={} ",serverMetadata);
        return Response.success();
    }


}

package com.simple.rpc.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RPCResponse<T> extends Response{

    T data;

    public static <T> RPCResponse success(T data){
        RPCResponse response = new RPCResponse(data);
        return response;
    }

}

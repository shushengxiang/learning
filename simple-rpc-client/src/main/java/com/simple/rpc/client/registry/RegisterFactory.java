package com.simple.rpc.client.registry;

import com.simple.rpc.common.constants.RPCType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:24
 **/
public class RegisterFactory {

    private static Map<RPCType,AbstractClientRegister> registerMap = new HashMap<>();

    static {
        //
        registerMap.put(RPCType.HTTP,new HttpClientRegister());
    }

    public static AbstractClientRegister getRegister(RPCType rpcType){
        return registerMap.get(rpcType);
    }

}

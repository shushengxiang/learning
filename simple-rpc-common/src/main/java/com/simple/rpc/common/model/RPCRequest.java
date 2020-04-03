package com.simple.rpc.common.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:52
 **/
@Data
@Builder
public class RPCRequest implements Serializable {

    Object proxy;

    Method method;

    Object[] args;

    ServerMetadata serverMetadata;

}

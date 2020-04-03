package com.simple.rpc.client.factory;

import com.simple.rpc.client.discovery.Discovery;
import com.simple.rpc.client.invoke.Invoker;
import com.simple.rpc.common.model.RPCRequest;
import com.simple.rpc.common.model.RPCResponse;
import com.simple.rpc.common.model.ServerMetadata;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 17:42
 **/
@Slf4j
@Data
public class HttpRPCFactoryBean<T> extends AbstractRPCHandler implements FactoryBean<T> {

    @Autowired
    private Discovery discovery;

    @Autowired
    private Invoker invoker;

    Class<T> clazz;

    String serverName;

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) -> {
            ServerMetadata serverMetadata = getLoadBalance().get(discovery.get(serverName));
            RPCRequest request = RPCRequest.builder().proxy(proxy).method(method).args(args).serverMetadata(serverMetadata).build();
            RPCResponse invoke = invoker.invoke(request);
            return invoke.getData();
        };

        T proxy = (T) Proxy.newProxyInstance(handler.getClass().getClassLoader(),new Class[]{clazz},handler);
        return proxy;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


}

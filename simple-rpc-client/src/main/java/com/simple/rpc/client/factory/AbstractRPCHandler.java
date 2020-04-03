package com.simple.rpc.client.factory;

import com.simple.rpc.client.loadbalance.LoadBalance;
import com.simple.rpc.client.loadbalance.RandomLoadBalance;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 16:40
 **/
@Data
public abstract class AbstractRPCHandler implements InitializingBean {

    LoadBalance loadBalance;

    @Autowired
    ConfigurableEnvironment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        String loadBalanceProperties = env.getProperty(new StringBuilder("simple.rpc.server")
                .append(getServerName()).append("loadBalance").toString());
        if (loadBalanceProperties == null){
            loadBalance = new RandomLoadBalance();
        }
    }

    public abstract String getServerName();
}

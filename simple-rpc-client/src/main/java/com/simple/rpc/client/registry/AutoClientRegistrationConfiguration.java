package com.simple.rpc.client.registry;

import com.simple.rpc.client.annotation.EnableSimpleRPC;
import com.simple.rpc.client.condition.HttpCondition;
import com.simple.rpc.common.annotation.SimpleRPCClient;
import com.simple.rpc.common.constants.RPCType;
import com.simple.rpc.common.util.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 17:46
 **/
//@EnableAspectJAutoProxy
//@Configuration
@Slf4j
public class AutoClientRegistrationConfiguration implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        log.info("Start AutoClientRegistrationConfiguration registerBeanDefinitions");
        String[] basePackages = getBasePackages(importingClassMetadata);

        log.info("Scan these packages {} to register the clients", Arrays.toString(basePackages));
        Set<Class<?>> classes = ClassScaner.scan(basePackages, SimpleRPCClient.class);

        boolean hasHttp = false;
        for (Class<?> clazz:classes){
            SimpleRPCClient simpleRPCClient = clazz.getAnnotation(SimpleRPCClient.class);
            if (simpleRPCClient.type() == RPCType.HTTP){
                hasHttp = true;
            }
            AbstractClientRegister register = RegisterFactory.getRegister(simpleRPCClient.type());
            Map<String,Object> attributes = new HashMap<>();
            attributes.put("clazz",clazz);
            attributes.put("serverName",simpleRPCClient.value());

            register.register(registry,clazz.getName(),attributes);
        }

        HttpCondition.enable = hasHttp;
    }

    private String[] getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableSimpleRPC.class.getCanonicalName() );
        return  (String[]) attributes.get( "basePackages" );
    }


}

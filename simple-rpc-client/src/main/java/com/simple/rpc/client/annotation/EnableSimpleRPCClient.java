package com.simple.rpc.client.annotation;

import com.simple.rpc.client.registry.AutoClientRegistrationConfiguration;
import com.simple.rpc.common.constants.RPCType;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AutoClientRegistrationConfiguration.class)
public @interface EnableSimpleRPCClient {

    RPCType value() default RPCType.HTTP;

}

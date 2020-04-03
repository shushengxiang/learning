package com.simple.rpc.common.annotation;

import com.simple.rpc.common.constants.RPCType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/31 17:47
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleRPCClient {

    /**
     * this is the server name
     * @return
     */
    String value();

    /**
     * this is type about rpc and the default is http
     * @return
     */
    RPCType type() default RPCType.HTTP;

}

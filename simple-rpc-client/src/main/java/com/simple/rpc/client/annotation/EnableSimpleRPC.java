package com.simple.rpc.client.annotation;

import com.simple.rpc.client.registry.AutoClientRegistrationConfiguration;
import org.springframework.context.annotation.Import;
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
@Import(AutoClientRegistrationConfiguration.class)
public @interface EnableSimpleRPC {

    /**
     * The scanner will scan classes in this packages to create proxy for client
     * @return
     */
    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};

}

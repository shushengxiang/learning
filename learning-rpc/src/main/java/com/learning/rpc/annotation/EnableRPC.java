package com.learning.rpc.annotation;


import com.learning.rpc.register.RPCConfigureRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RPCConfigureRegistrar.class)
public @interface EnableRPC {
}

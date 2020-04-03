package com.simple.rpc.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/4/2 17:16
 **/
public class HttpCondition implements Condition {

    public static boolean enable = false;

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        return enable;
    }
}

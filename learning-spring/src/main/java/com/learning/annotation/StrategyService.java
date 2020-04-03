package com.learning.annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 14:46
 **/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StrategyService {

    int value();

}

package com.learning.handler;

import com.learning.annotation.StrategyService;
import com.learning.util.ClassScaner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:02
 **/
@Slf4j
@Component
public class MyHandlerProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        log.info("Start postProcessBeanFactory in MyHandlerProcessor");

        Map<Integer,Class> map = new HashMap<Integer,Class>();

        ClassScaner.scan("com.learning", StrategyService.class).forEach(x ->{
            int type = x.getAnnotation(StrategyService.class).value();
            map.put(type,x);
        });
        beanFactory.registerSingleton(StrategyService.class.getName(), map);
        log.info("End postProcessBeanFactory in MyHandlerProcessor");
    }

}

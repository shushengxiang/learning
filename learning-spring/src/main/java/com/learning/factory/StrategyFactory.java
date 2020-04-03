package com.learning.factory;

import com.learning.annotation.StrategyService;
import com.learning.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:08
 **/
@Component
public class StrategyFactory {

    @Autowired
    private ApplicationContext beanFactory;

    public MyService getInstance(Integer type){
        Map<Integer,Class> map = (Map<Integer, Class>) beanFactory.getBean(StrategyService.class.getName());
        return (MyService)beanFactory.getBean(map.get(type));
    }

}

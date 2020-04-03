package com.learning.controller;

import com.learning.annotation.Strategy;
import com.learning.factory.StrategyFactory;
import com.learning.service.impl.MyStrategy1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:06
 **/
@Slf4j
@RestController
public class MyController {

    @Autowired
    StrategyFactory strategyFactory;

    @Strategy(1)
    MyStrategy1Service strategy1Service;

    @GetMapping("/v1/test/{value}")
    public Map<String,Object> test(@PathVariable int value){
        log.info("Receive one request,parameters is {}",value);
        Map<String,Object> result = new HashMap<>();
        result.put("result",strategyFactory.getInstance(value).execute(value));
        return result;
    }

    @GetMapping("/v1/test1")
    public Map<String,Object> test1(){
//        log.info("Receive one request,parameters is {}",value);
        Map<String,Object> result = new HashMap<>();
        result.put("result",strategy1Service.execute(1));
        return result;
    }

}

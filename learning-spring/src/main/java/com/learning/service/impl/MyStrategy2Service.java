package com.learning.service.impl;

import com.learning.annotation.StrategyService;
import com.learning.service.MyService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:11
 **/
@Slf4j
@StrategyService(2)
public class MyStrategy2Service implements MyService {

    @Override
    public int execute(int value) {
        log.info("Execute MyStrategy2222Service");
        return 2;
    }
}

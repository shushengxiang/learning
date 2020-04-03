package com.learning.service.impl;

import com.learning.annotation.StrategyService;
import com.learning.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author shushengxiang
 * @Date 2020/3/30 15:09
 **/
@StrategyService(1)
@Slf4j
public class MyStrategy1Service implements MyService {

    @Override
    public int execute(int value) {
        log.info("Execute MyStrategy1111Service");
        return 1;
    }
}

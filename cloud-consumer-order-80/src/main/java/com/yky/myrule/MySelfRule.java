package com.yky.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0
 * @ClassName MySelfRule
 * @Description TODO 规则类 Ribbon核心组件
 * @Author YKY
 * @Date 2020/9/21 16:27
 **/
public class MySelfRule {
    @Bean
    public IRule myRule() {
        //定义为随机
        return new RandomRule();
    }
}

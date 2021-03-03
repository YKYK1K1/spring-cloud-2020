package com.yky.spring.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @version 1.0
 * @ClassName FeignConfig
 * @Description TODO
 * @Author YKY
 * @Date 2020/11/3 15:44
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

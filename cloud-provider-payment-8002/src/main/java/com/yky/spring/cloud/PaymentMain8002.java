package com.yky.spring.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @version 1.0
 * @ClassName PaymentMain8001
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/7 14:09
 **/
@MapperScan(basePackages = "com.yky.spring.cloud.dao")
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}

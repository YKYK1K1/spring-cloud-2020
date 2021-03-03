package com.yky.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @ClassName PaymentMain8004
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/18 8:47
 **/
@SpringBootApplication
/**
 * 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
 */
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}

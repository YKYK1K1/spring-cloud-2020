package com.yky.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @version 1.0
 * @ClassName OrderConsulMain80
 * @Description TODO
 * @Author YKY
 * @Date 2020/9/9 14:31
 **/
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用 consul 或者 zookeeper 作为注册中心时注册服务
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}

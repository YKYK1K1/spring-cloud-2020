package com.yky.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yky.spring.cloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @ClassName OrderHystrixController
 * @Description TODO
 * @Author YKY
 * @Date 2020/11/24 16:45
 **/
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = service.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String result = service.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutFallbackMethod(Integer id) {
        return "我是消费者 80,对方支付系统繁忙请10秒后再试!,/(ㄒoㄒ)/~~";
    }

    //下面是全局 fallback 方法
    public String payment_Global_FallbackMethod() {
        return "Global 异常处理信息,请稍后再试,/(ㄒoㄒ)/~~";
    }
}

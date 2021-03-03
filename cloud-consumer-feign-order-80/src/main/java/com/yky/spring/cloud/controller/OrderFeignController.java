package com.yky.spring.cloud.controller;

import com.yky.spring.cloud.domain.Payment;
import com.yky.spring.cloud.service.PaymentFeignService;
import com.yky.spring.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @ClassName OrderFeignController
 * @Description TODO
 * @Author YKY
 * @Date 2020/10/13 14:40
 **/
@Slf4j
@RestController
@RequestMapping(value = "/consumer/payment")
public class OrderFeignController {
    @Resource
    private PaymentFeignService service;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getByPrimaryKey(@PathVariable("id") Long id) {
        return service.getByPrimaryKey(id);
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign-ribbon,客户端一般默认等待1秒钟
        return service.paymentFeignTimeout();
    }

}
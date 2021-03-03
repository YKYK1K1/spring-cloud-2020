package com.yky.spring.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @ClassName PaymentFallbackService
 * @Description TODO
 * @Author YKY
 * @Date 2020/11/27 14:21
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fallback paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService fallback paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}

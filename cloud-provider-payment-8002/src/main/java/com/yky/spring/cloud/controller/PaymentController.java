package com.yky.spring.cloud.controller;

import com.yky.spring.cloud.domain.Payment;
import com.yky.spring.cloud.service.PaymentService;
import com.yky.spring.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @ClassName PaymentController
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/7 14:59
 **/
@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        log.info("调用 create 方法 参数：{}", payment);
        int result = paymentService.insert(payment);
        log.info("create 方法 插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据库失败,serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getByPrimaryKey(@PathVariable("id") Long id) {
        log.info("调用 getByPrimaryKey 方法 参数：{}", id);
        Payment payment = paymentService.selectByPrimaryKey(id);
        log.info("getByPrimaryKey 方法 查询结果：" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "没用对应记录，查询ID：" + id + ",serverPort:" + serverPort, null);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * 手动测试暂停 3 秒线程
     *
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            //暂停几秒线程
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
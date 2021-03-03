package com.yky.spring.cloud.controller;

import com.yky.spring.cloud.domain.Payment;
import com.yky.spring.cloud.lb.LoadBalancer;
import com.yky.spring.cloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @version 1.0
 * @ClassName OrderController
 * @Description TODO
 * @Author YKY
 * @Date 2020/8/7 16:29
 **/
@Slf4j
@RequestMapping(value = "/consumer/payment")
@RestController
public class OrderController {
// private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/create")
    public CommonResult create(Payment payment) {
        log.info("通过 create 调用 PAYMENT 服务 添加信息：{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info("通过 getPayment 调用 PAYMENT 服务 添加信息：{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 返回对象为 ResponseEntity 对象,包含了响应中的一些重要信息m,比如响应头、响应状态码、响应体等
     *
     * @param id id
     * @return CommonResult
     */
    @GetMapping(value = "/getForEntity/{id}")
    public CommonResult getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info(entity.getStatusCode() + "\t" + entity.getHeaders());
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/postForEntity")
    public CommonResult postPayment(Payment payment) {
        CommonResult body = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
        if ("200".equals(body.getCode())) {
            log.info(body.toString());
            return body;
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}

package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;


/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/13
 * rpc
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE") // 微服务名称
@RequestMapping("/payment")
public interface PaymentFeignService {
    @PostMapping("/create")
    CommonResult create(Payment payment);

    @GetMapping("/get/{id}")
    CommonResult getPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/discovery")
    Object discovery();

    @GetMapping("/lb")
    String lb();

    @GetMapping("/feign/timeout")
    String paymentFeignTimeout();
}

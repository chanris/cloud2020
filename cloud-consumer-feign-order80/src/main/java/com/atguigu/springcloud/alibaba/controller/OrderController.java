package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Slf4j
@RestController
public class OrderController {
    @Resource
    PaymentFeignService paymentFeignService;

    // feign 默认一秒钟超时
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return paymentFeignService.getPayment(id);
    }
}

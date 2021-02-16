package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Slf4j
@RestController
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; // 通过微服务名称去找，不用管端口
    @Resource
    RestTemplate restTemplate;
    @Resource
    LoadBalancer loadBalancer;
    @Resource
    DiscoveryClient discoveryClient;


    // postForObject返回json
    @PostMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        log.info("payment:" + payment);
        // params封装成 MultiValueMap 注意Map和hashMap都不行！！
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap();
        paramMap.put("serial", Collections.singletonList(payment.getSerial()));
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",paramMap, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }
    // ResponseEntity 还会携带响应码之类的其他信息
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }
        return new CommonResult<>(444,"操作失败");
    }
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        log.info("====uri:"+uri);
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}

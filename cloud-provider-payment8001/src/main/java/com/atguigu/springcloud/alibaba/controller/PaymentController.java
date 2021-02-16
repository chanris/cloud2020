package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private Integer serverPort;
    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/create")
    public CommonResult create(/*@RequestBody*/ Payment payment){
        int result = paymentService.save(payment);
        log.debug("*****插入结果:"+result);
        if (result > 0){
            return new CommonResult(200,"插入成功 serverPort:"+serverPort);
        }else {
            return new CommonResult(444, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getOneById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功 serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444, "查询失败,查询id:"+id);
        }
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(serverPort);
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> serviceInfos = discoveryClient.getServices();
        for (String element: serviceInfos){
            log.info("******element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String lb(){
        return String.valueOf(serverPort);
    }
}

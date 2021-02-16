package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/14
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") // 解决代码膨胀的问题
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }
 /*   @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="1500")
    })*/
    @HystrixCommand  // 使用默认的服务降级方法 把之前的配置注释掉
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable Integer id){
        //int num = 10/0; /*模拟80自己错误*/
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，/(ㄒoㄒ)/~~";
    }
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试/(ㄒoㄒ)/~~";
    }
}

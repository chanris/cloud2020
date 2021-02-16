package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/13
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id："+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="3000") /*处理方法超过3秒到fallback方法*/
    })
    public String paymentInfo_TimeOut(Integer id){
        // 服务超时测试
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 服务异常测试
        //int num = 10 / 0;
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id："+id+"\t"+"O(∩_∩)O哈哈~" + "耗时2秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙或运行报错，请稍后再试,id："+id+"\t"+"/(ㄒoㄒ)/~~服务繁忙";
    }

    //=======服务熔断
    // 服务熔断不服务降级高级一点: 服务先是遇到错误降级，当错误请求占到一定比例时，就会触发熔断，发生熔断期间，就会请求正常也可能返回错误，
    // 直到正常请求占到一定比例时才会恢复服务
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            //参数都在 HystrixCommandProperties  配置的大概意思是10秒内请求10次中失败6次就熔断服务
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   // 请求次数10
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口器 10s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")    // 失败率到达多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号:" + serialNumber;
    }
    public String  paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数， 请稍后再试,/(ㄒoㄒ)/~~ id:" + id;
    }
}

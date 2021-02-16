package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@SpringBootApplication
@EnableEurekaClient
/*@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = {MySelfRule.class})*/
public class OrderApplication80 {
    public static void main(String[] args){
        SpringApplication.run(OrderApplication80.class, args);
    }
}

package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentApplication9004 {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication9004.class, args);
    }
}

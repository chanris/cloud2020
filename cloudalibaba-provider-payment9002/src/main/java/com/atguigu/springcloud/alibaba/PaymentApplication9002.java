package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 */
@EnableDiscoveryClient // nacos 服务发现
@SpringBootApplication
public class PaymentApplication9002 {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication9002.class, args);
    }
}

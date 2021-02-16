package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.atguigu.springcloud.dao")
public class PaymentApplication8002 {
    public static void main(String[] args){
        SpringApplication.run(PaymentApplication8002.class, args);
    }
}

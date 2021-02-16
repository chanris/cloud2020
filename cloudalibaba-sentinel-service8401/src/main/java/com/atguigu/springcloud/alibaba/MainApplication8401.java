package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApplication8401 {
    public static void main(String[] args){
        SpringApplication.run(MainApplication8401.class, args);
    }
}

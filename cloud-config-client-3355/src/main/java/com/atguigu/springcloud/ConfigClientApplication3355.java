package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 */

@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication3355 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientApplication3355.class, args);
    }
}

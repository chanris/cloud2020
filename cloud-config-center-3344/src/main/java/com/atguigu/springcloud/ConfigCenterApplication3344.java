package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigCenterApplication3344 {
    public static void main(String[] args){
        SpringApplication.run(ConfigCenterApplication3344.class, args);
    }
}

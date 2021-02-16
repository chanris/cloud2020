package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7003 {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication7003.class, args);
    }
}

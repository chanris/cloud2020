package com.atguigu.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenyue7@foxmail.com
 */
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.atguigu.springcloud.alibaba.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataAccountApplication2003 {
    public static void main(String[] args){
        SpringApplication.run(SeataAccountApplication2003.class, args);
    }
}

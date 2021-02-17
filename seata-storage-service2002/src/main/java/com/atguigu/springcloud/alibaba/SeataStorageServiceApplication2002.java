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
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients     //feign
@EnableDiscoveryClient  //nacos service-registry-center
@MapperScan(basePackages = "com.atguigu.springcloud.alibaba.dao")
public class SeataStorageServiceApplication2002 {
    public static void main(String[] args){
        SpringApplication.run(SeataStorageServiceApplication2002.class, args);
    }
}

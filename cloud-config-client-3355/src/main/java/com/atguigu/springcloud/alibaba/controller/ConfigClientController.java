package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 * 手动刷新配置步骤
 * 1. 修改github上配置项
 * 2. 在客户端pom加上spring-boot-starter-actuator
 * 3. controller加上@RefreshScope
 * 4. 发一个刷新配置的POST请求 POST http://localhost:3355/actuator/refresh
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}

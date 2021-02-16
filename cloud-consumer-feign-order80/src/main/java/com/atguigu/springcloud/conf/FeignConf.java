package com.atguigu.springcloud.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/13
 */
@Configuration
public class FeignConf {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL; /*NONE,BASIC,HEADERS,FULL*/
    }
}

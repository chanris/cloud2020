package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/15
 */
@Slf4j
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }
    @GetMapping("/testD")
    public String testD(){
        try {
            MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "-----testD";
    }
}

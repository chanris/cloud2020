package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    /**
     * 测试熔断降级-慢调用(RT)-异常比例
     */
    @GetMapping("/testD")
    public String testD(){
//        try {
//            MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int num = 10/0; //异常比例
        return "-----testD";
    }
    /**
     * 测试熔断降级-异常数
     */
    @GetMapping("/testE")
    public String testE(){
        log.info("test E 测试异常数");
        int num = 10/0;
        return "------test E 测试异常比例";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")/*没设置blockHandler会直接报错*/
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int num = 10/0;
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "------deal_testHotKey,/(ㄒoㄒ)/~~";
    }

}

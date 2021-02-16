package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/16
 */
@Slf4j
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源吗限流测试OK", new Payment(2020L, "serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName()+"\t"+"服务不可用");
    }
    /*使用url方式配置的流控规则,起效后返回sentinel默认的流控信息 Blocked by Sentinel (flow limiting)*/
    /*如果要使用自定义的流控处理器，请使用SentinelResource资源名配置流控规则*/
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按url限流测试OK",new Payment(2020L, "serial002"));
    }
    //customerBlockHandler
    /*指定流控处理类和处理方法*/
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200, "按客户自定义",new Payment(2020L, "serial003"));
    }
}

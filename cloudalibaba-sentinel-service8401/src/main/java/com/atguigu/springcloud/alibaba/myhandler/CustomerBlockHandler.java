package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/16
 */

public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException e){
        return new CommonResult(444, "按客户自定义. global handle Exception ---- 1");
    }
    public static CommonResult handleException2(BlockException e){
        return new CommonResult(444, "按客户自定义. global handle Exception ----- 2");
    }
}

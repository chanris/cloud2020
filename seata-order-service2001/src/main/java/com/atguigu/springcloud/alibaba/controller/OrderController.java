package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyue7@foxmail.com
 */
@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/order/create")
    public CommonResult create(@RequestBody Order order){
        System.out.println("-------->order init ------");
        orderService.create(order);
        return new CommonResult(200, "创建订单成功");
    }
}

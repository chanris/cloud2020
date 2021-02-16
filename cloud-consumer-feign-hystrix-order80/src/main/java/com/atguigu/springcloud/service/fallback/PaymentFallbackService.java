package com.atguigu.springcloud.service.fallback;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/14
 * 服务降级优雅的实现方式
 * PaymentHystrixService RPC 的所有api兜底方法实现
 *
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbakService fall back-paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbakService fall back-paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}

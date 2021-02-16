package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
public interface PaymentService {
    int save(Payment payment);
    Payment getOneById(Long id);
}

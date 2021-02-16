package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getOneById(Long id) {
        return paymentDao.getOneById(id);
    }
}

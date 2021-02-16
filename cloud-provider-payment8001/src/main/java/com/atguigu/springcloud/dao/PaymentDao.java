package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.springframework.stereotype.Repository;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Repository
public interface PaymentDao {
    int insert(Payment payment);
    Payment getOneById(Long id);
}

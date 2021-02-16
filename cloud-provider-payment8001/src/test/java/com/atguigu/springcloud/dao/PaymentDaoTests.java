package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@SpringBootTest
public class PaymentDaoTests {
    @Autowired
    PaymentDao paymentDao;

    @Test
    @Disabled("skip run")
    public void testInsert(){
        Payment payment = new Payment("012-ksdi1246");
        paymentDao.insert(payment);
    }
}

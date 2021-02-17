package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chenyue7@foxmail.com
 */
@Repository
public interface OrderDao {

    /**
     * 创建订单
     */
    int create(Order order);

    /**
     *
     * 修改订单状态 从0到1
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}

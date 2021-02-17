package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chenyue7@foxmail.com
 */
@Repository
public interface StorageDao {
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}

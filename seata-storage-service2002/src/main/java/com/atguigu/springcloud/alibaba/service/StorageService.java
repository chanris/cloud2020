package com.atguigu.springcloud.alibaba.service;

/**
 * @author chenyue7@foxmail.com
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}

package com.atguigu.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Data
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
    public Payment(String serial){
        this.serial = serial;
    }
}

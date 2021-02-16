package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T> {
    private Integer code;
    private String  msg;
    private T       data;
    public CommonResult(Integer code, String msg){
        this.code = code;
        this.msg  = msg;
    }
}

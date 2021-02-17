package com.atguigu.springcloud.alibaba.conf.exception;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler({Exception.class})
    public CommonResult defaultHandle(Exception e){
        return new CommonResult(500, "Server Internal Error", "异常信息:"+e.getMessage());
    }
}

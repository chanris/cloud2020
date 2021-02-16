package com.atguigu.springcloud.exception;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/13
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    public CommonResult defaultHandler(Exception e){
        return new CommonResult(500, "服务器内部错误", e.getMessage());
    }
}

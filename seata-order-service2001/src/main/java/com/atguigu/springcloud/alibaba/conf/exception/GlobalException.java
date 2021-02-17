package com.atguigu.springcloud.alibaba.conf.exception;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 */
public class GlobalException extends RuntimeException {
    public GlobalException() {
    }
    public GlobalException(String message) {
        super(message);
    }
    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }
    public GlobalException(Throwable cause) {
        super(cause);
    }
}

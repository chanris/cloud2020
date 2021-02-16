package com.atguigu.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/12
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule rule(){
        return new RoundRobinRule(); /*RandomRule() 随机请求 */
    }

    static class MySimpleRule extends AbstractLoadBalancerRule {
        @Override
        public void initWithNiwsConfig(IClientConfig iClientConfig) {

        }

        public Server choose(ILoadBalancer lb, Object key) {
            return null;
        }

        @Override
        public Server choose(Object key) {
            return choose(getLoadBalancer(), key);
        }
    }
}

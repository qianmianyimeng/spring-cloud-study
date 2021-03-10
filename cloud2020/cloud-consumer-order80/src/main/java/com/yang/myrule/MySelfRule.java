package com.yang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yang
 * @date 2021/3/1--7:45
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule MyselfRule()
    {
        return new RandomRule();
    }
}

package com.yang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yang
 * @date 2021/3/4--13:58
 */

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {
    public static void main(String[] args)
        {
            SpringApplication.run(ConfigClientMain3366.class, args);
        }
}

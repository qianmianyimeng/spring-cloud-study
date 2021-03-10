package com.yang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yang
 * @date 2021/2/28--16:58
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
public static void main(String[] args)
    {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}

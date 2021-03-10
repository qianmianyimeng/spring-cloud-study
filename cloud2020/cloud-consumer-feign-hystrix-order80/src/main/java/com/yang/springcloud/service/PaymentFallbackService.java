package com.yang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yang
 * @date 2021/3/3--9:33
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-=-=-=-=PaymentFallbackServiceo(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "超时方法o(╥﹏╥)o";
    }
}

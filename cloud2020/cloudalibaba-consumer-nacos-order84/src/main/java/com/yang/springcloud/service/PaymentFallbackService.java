package com.yang.springcloud.service;

import com.yang.springcloud.entities.CommonResult;
import com.yang.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @date 2021/3/8--9:39
 */

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回，paymentFallbackService",new Payment(id,"errorSerial"));
    }
}

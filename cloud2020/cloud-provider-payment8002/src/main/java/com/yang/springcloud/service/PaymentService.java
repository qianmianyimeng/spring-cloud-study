package com.yang.springcloud.service;

import com.yang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author yang
 * @date 2021/2/26--14:49
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

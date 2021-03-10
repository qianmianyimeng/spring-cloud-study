package com.yang.springcloud.service.impl;

import com.yang.springcloud.dao.PaymentDao;
import com.yang.springcloud.entities.Payment;
import com.yang.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2021/2/26--14:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentdao;

    public int create(Payment payment)
    {
        return paymentdao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentdao.getPaymentById(id);
    }
}

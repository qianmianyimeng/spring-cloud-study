package com.yang.springcloud.controller;

import com.yang.springcloud.entities.CommonResult;
import com.yang.springcloud.entities.Payment;
import com.yang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2021/2/26--14:51
 */

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("****插入结果****"+result);

        if (result > 0)
        {
            return new CommonResult(200,"插入数据库成功:"+serverPort,result);
        }else
        {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果****"+payment);

        if (payment != null)
        {
            return new CommonResult(200,"查询成功:"+serverPort,payment);
        }else
        {
            return new CommonResult(444,"查询失败,没有"+id,null);
        }
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}


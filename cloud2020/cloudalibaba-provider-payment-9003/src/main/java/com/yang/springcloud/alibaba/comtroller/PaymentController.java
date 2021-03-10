package com.yang.springcloud.alibaba.comtroller;

import com.yang.springcloud.entities.CommonResult;
import com.yang.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

import java.util.HashMap;

/**
 * @author yang
 * @date 2021/3/7--20:40
 */

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static
    {
        hashMap.put(1L,new Payment(1L,"111111111111111"));
        hashMap.put(2L,new Payment(2L,"222222222222222"));
        hashMap.put(3L,new Payment(3L,"333333333333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id)
    {
        Payment payment =hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:"+serverPort,payment);
        return result;
    }
}

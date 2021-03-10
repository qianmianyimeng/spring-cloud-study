package com.yang.springcloud.alibaba.controller;

import com.yang.springcloud.alibaba.domain.CommonResult;
import com.yang.springcloud.alibaba.domain.Order;
import com.yang.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2021/3/8--17:06
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

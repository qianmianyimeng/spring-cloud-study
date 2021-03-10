package com.yang.controller;

import com.yang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yang
 * @date 2021/3/9--9:52
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/snowflake")
    public String index()
    {
        return orderService.getIDBySnowFlake();
    }
}

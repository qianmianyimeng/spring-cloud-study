package com.yang.springcloud.alibaba.service;

import com.yang.springcloud.alibaba.domain.Order;

/**
 * @author yang
 * @date 2021/3/8--16:32
 */
public interface OrderService {
    void create(Order order);
}

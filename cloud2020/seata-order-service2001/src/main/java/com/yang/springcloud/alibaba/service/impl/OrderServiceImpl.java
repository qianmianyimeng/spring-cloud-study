package com.yang.springcloud.alibaba.service.impl;

import com.yang.springcloud.alibaba.dao.OrderDao;
import com.yang.springcloud.alibaba.domain.Order;
import com.yang.springcloud.alibaba.service.AccountService;
import com.yang.springcloud.alibaba.service.OrderService;
import com.yang.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2021/3/8--16:34
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "weiyi-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----开始新建订单");
        orderDao.create(order);

        log.info("-----订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-----订单微服务开始调用库存，做扣减end");

        log.info("-----订单微服务开始调用账户,做扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-----订单微服务开始调用账户，做扣减end");

        log.info("-----修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("-----修改订单结束");

        log.info("----下订单结束，哈哈");

    }
}

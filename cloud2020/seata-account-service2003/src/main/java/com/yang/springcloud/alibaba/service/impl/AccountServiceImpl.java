package com.yang.springcloud.alibaba.service.impl;

import com.yang.springcloud.alibaba.dao.AccountDao;
import com.yang.springcloud.alibaba.domain.Account;
import com.yang.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @date 2021/3/8--16:34
 */

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {

        LOGGER.info("-----account-service中扣减余额开始");
        try{ TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId, money);
        LOGGER.info("-----account-service中扣减余额结束");

    }
}

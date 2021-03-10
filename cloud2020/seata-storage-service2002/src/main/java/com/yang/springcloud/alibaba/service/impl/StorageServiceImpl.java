package com.yang.springcloud.alibaba.service.impl;

import com.yang.springcloud.alibaba.dao.StorageDao;
import com.yang.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yang
 * @date 2021/3/8--16:34
 */

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Resource
    private StorageService storageService;

    @Override
    public void decrease(Long productId,Integer count) {

        LOGGER.info("-----storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("-----storage-service中扣减库存结束");

    }
}

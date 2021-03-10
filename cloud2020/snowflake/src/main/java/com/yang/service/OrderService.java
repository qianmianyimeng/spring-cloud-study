package com.yang.service;

import com.yang.boot.util.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yang
 * @date 2021/3/9--9:53
 */

@Service
public class OrderService {
    @Autowired
    private IdGeneratorSnowflake idGenerator;

    public String getIDBySnowFlake()
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <=20 ; i++) {
            threadPool.submit(()->{
                System.out.println(idGenerator.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}

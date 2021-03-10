package com.yang.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yang
 * @date 2021/3/8--17:09
 */

@Configuration
@MapperScan({"com.yang.springcloud.alibaba.dao"})
public class MyBatisConfig {

}

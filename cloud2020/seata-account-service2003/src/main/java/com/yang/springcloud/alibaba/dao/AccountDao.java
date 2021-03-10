package com.yang.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * @author yang
 * @date 2021/3/8--16:09
 */

@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}

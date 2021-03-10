package com.yang.springcloud.alibaba.dao;

import com.yang.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @date 2021/3/8--16:09
 */

@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId,@Param("status") Integer status);
}

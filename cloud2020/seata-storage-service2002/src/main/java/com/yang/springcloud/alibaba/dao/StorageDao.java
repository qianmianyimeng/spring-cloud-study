package com.yang.springcloud.alibaba.dao;

import com.yang.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yang
 * @date 2021/3/8--16:09
 */

@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}

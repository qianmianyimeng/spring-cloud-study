package com.yang.springcloud.alibaba.service;

import com.yang.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yang
 * @date 2021/3/8--16:38
 */

public interface StorageService{
    void decrease(Long productId,Integer count);
}

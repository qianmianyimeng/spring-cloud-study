package com.yang.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yang.springcloud.entities.CommonResult;
import com.yang.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author yang
 * @date 2021/3/7--18:21
 */

@Component
public class customerBlockHandler {
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(4444,"按客户自定义111");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客户自定义222");
    }
}

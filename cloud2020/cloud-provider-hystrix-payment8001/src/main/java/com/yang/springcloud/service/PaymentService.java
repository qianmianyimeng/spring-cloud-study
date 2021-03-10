package com.yang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.TimeUnit;

/**
 * @author yang
 * @date 2021/3/2--13:29
 */

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id)
    {
        return "线程池:" +Thread.currentThread().getName()+"paymentInfo_OK,id"+id+"\t"+"哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_OK_Timeout(Integer id)
    {
        try{ TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:" +Thread.currentThread().getName()+"paymentInfo_Timeout ,id"+id+"\t"+"he";
    }

    public String paymentInfo_TimeOutHandler(Integer id)
    {
        return "线程池"+ Thread.currentThread().getName()+"8001paymentInfo_TimeOutHandler"+id+"\t"+"eee";
    }

    //===服务熔断===

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),    //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if (id < 0)
        {
            throw new RuntimeException("id不能小于0");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id不能为负数";
    }
}

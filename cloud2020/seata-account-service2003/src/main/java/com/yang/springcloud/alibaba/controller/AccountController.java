package com.yang.springcloud.alibaba.controller;

import com.yang.springcloud.alibaba.domain.CommonResult;
import com.yang.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yang
 * @date 2021/3/8--17:06
 */

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;


    //扣减库存
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减余额成功！");
    }
}
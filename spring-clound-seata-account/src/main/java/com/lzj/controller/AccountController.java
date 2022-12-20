package com.lzj.controller;

import com.lzj.service.AccountService;
import com.lzj.service.TccAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TccAccountService tccAccountService;

    @PutMapping("/decrease")
    public void decrease(String userId, int money) throws Exception {
        //accountService.decrease(userId, money);
        tccAccountService.tryDecrease(userId, money);
    }
}

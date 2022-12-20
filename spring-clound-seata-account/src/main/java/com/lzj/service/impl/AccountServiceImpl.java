package com.lzj.service.impl;

import com.lzj.mapper.AccountMapper;
import com.lzj.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public void decrease(String userId, int money) throws Exception {
        mapper.decrease(userId, money);
    }
}

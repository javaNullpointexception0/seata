package com.lzj.service.impl;

import com.lzj.mapper.AccountMapper;
import com.lzj.service.TccAccountService;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TccAccountServiceImpl implements TccAccountService {

    private static final Logger log = LoggerFactory.getLogger(TccAccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Boolean tryDecrease(String userId, int money) {
        int i = 0;
        System.out.println(8/i);
        //try阶段，可用余额减少，占用金额增加
        log.info("tryDecrease start ...");
        accountMapper.tryDecrease(userId, money);
        log.info("tryDecrease end ...");
        return Boolean.TRUE;
    }

    @Override
    public Boolean confirmDecrease(BusinessActionContext context) {
        //从上下文中取出try阶段的参数，confirm阶段，可用余额不变，占用金额扣减
        log.info("confirmDecrease start ...");
        String userId = (String) context.getActionContext().get("userId");
        Integer money = (Integer) context.getActionContext().get("money");
        accountMapper.confirmDecrease(userId, money);
        log.info("confirmDecrease end ...");
        return Boolean.TRUE;
    }

    @Override
    public Boolean cancelDecrease(BusinessActionContext context) {
        //从上下文中取出try阶段的参数，confirm阶段，可用余额增加，占用金额扣减
        log.info("cancelDecrease start ...");
        String userId = (String) context.getActionContext().get("userId");
        Integer money = (Integer) context.getActionContext().get("money");
        accountMapper.cancelDecrease(userId, money);
        log.info("cancelDecrease end ...");
        return Boolean.TRUE;
    }
}

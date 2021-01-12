package com.lzj.service.impl;

import com.lzj.entity.Order;
import com.lzj.service.AccountService;
import com.lzj.service.BusinessService;
import com.lzj.service.OrderService;
import com.lzj.service.StorageService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "SEATA-SERVER", rollbackFor = Exception.class)
    public void purchase(String userId, String commodityCode, int orderCount) {
        //生成订单
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderCount * 10);
        Integer orderId = orderService.create(order);
        //扣减库存
        storageService.deduct(commodityCode, orderCount);
        //扣减账号余额
        accountService.decrease(userId, order.getMoney());
        //更新订单
        orderService.update(orderId, 1);
    }
}

package com.lzj.service.impl;

import com.lzj.entity.Order;
import com.lzj.mapper.OrderMapper;
import com.lzj.service.OrderService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer create(Order order) {
        //String xid = RootContext.getXID();
        order.setStatus(0);
        // INSERT INTO orders ...
        orderMapper.insert(order);
        return order.getId();
    }

    @Override
    public void update(Integer id, Integer status) {
        orderMapper.update(id, status);
    }
}

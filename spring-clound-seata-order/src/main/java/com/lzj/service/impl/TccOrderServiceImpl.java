package com.lzj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzj.entity.Order;
import com.lzj.mapper.OrderMapper;
import com.lzj.service.TccOrderService;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TccOrderServiceImpl implements TccOrderService {
    private static final Logger log = LoggerFactory.getLogger(TccOrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer tryCreate(Order order) {
        //try阶段，预占资源，资源实际未真实提交，这里通过设置订单状态为0状态，代表订单未生效
        //try阶段，其实数据已经落库
        log.info("tryCreate start ...");
        order.setStatus(0);
        orderMapper.insert(order);
        log.info("tryCreate end ...");

        //返回订单id
        return order.getId();
    }

    @Override
    public Integer confirmOrder(BusinessActionContext context) {
        //获取try阶段的参数
        log.info("confirmOrder start ...");
        Order order = (Order) context.getActionContext().get("order");
        //confirm阶段，提交分布式事务，将订单状态改为生效状态
        orderMapper.update(order.getId(), 1);
        log.info("confirmOrder end ...");
        return order.getId();
    }

    @Override
    public Integer cancelOrder(BusinessActionContext context) {
        //获取try阶段的参数
        log.info("cancelOrder start ...");
        Order order = JSON.toJavaObject((JSONObject)context.getActionContext().get("order"), Order.class);
        //cancel阶段，回滚分布式事务，将订单进行删除
        orderMapper.deleteById(order.getId());
        log.info("cancelOrder end ...");
        return order.getId();
    }
}

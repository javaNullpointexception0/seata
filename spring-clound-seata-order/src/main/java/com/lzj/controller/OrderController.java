package com.lzj.controller;

import com.lzj.entity.Order;
import com.lzj.service.OrderService;
import com.lzj.service.TccOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private TccOrderService tccOrderService;

    @PostMapping("/create")
    Integer create(@RequestBody  Order order) {
        //AT模式
        //return orderService.create(order);
        //TCC模式
        return tccOrderService.tryCreate(order);
    }


    @PutMapping("/update")
    public void update(Integer id, Integer status) {
        orderService.update(id, status);
    }
}

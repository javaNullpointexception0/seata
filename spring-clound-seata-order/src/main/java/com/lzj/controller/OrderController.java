package com.lzj.controller;

import com.lzj.entity.Order;
import com.lzj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    Integer create(@RequestBody  Order order) {
       return orderService.create(order);
    }

    @PutMapping("/update")
    public void update(Integer id, Integer status) {
        orderService.update(id, status);
    }
}

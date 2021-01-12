package com.lzj.service;

import com.lzj.entity.Order;

public interface OrderService {
    /**
     *  create order
     */
    Integer create(Order order);

    /**
     * update order status
     * @param id
     * @param status
     */
    void update(Integer id, Integer status);
}

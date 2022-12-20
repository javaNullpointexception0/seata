package com.lzj.service;

import com.lzj.common.interceptor.SeataRequestInterceptor;
import com.lzj.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SPRING-CLOUD-SEATA-ORDER", configuration = SeataRequestInterceptor.class)
public interface OrderService {

    @PostMapping("/order/create")
    Integer create(Order order);

    @PutMapping("/order/update")
    void update(@RequestParam("id") Integer id, @RequestParam("status") Integer status);
}

package com.lzj.controller;

import com.lzj.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private BusinessService bussinessService;

    @RequestMapping("createOrder")
    public String createOrder(String userId, String commodityCode, int orderCount) {
        bussinessService.purchase(userId, commodityCode, orderCount);
        return "下单成功！";
    }

    @RequestMapping("createOrderInTcc")
    public String createOrderInTcc(String userId, String commodityCode, int orderCount) {
        bussinessService.createOrderInTcc(userId, commodityCode, orderCount);
        return "下单成功！";
    }
}

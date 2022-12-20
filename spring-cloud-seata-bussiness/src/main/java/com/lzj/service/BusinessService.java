package com.lzj.service;

public interface BusinessService {

    /**
     * AT模式 purchase
     */
    void purchase(String userId, String commodityCode, int orderCount);

    /**
     * TCC模式 purchase
     */
    void createOrderInTcc(String userId, String commodityCode, int orderCount);
}

package com.lzj.service;

public interface StorageService {

    /**
     * deduct storage count
     */
    void deduct(String commodityCode, int count);
}

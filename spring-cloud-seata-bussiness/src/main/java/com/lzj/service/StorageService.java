package com.lzj.service;

import com.lzj.common.interceptor.SeataRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="SPRING-CLOUD-SEATA-STORAGE", configuration = SeataRequestInterceptor.class)
public interface StorageService {

    @PutMapping("/storage/deduct")
    public void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);
}

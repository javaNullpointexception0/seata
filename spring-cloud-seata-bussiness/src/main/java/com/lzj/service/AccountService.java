package com.lzj.service;

import com.lzj.common.interceptor.SeataRequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="SPRING-CLOUD-SEATA-ACCOUNT", configuration = SeataRequestInterceptor.class)
public interface AccountService {

    @PutMapping("/account/decrease")
    public void decrease(@RequestParam("userId") String userId, @RequestParam("money") int money);
}

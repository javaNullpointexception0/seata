package com.lzj.service;

public interface AccountService {
    /**
     * decrease balance of user's account
     */
    void decrease(String userId, int money)  throws Exception;
}

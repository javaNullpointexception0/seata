package com.lzj.controller;

import com.lzj.service.StorageService;
import com.lzj.service.TccStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private TccStorageService tccStorageService;

    @RequestMapping("deduct")
    void deduct(String commodityCode, int count) {
        //storageService.deduct(commodityCode, count);
        tccStorageService.tryDeduct(commodityCode, count);
    }
}

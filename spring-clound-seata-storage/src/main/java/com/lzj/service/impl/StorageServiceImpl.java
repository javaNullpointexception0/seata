package com.lzj.service.impl;

import com.lzj.mapper.StorageMapper;
import com.lzj.service.StorageService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void deduct(String commodityCode, int count) {
        String xid = RootContext.getXID();
        storageMapper.deduct(commodityCode, count);
    }
}

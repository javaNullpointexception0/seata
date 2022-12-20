package com.lzj.service.impl;

import com.lzj.mapper.StorageMapper;
import com.lzj.service.TccStorageService;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TccStorageServiceImpl implements TccStorageService {

    private static final Logger log = LoggerFactory.getLogger(TccStorageServiceImpl.class);
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public Boolean tryDeduct(String commodityCode, int count) {
        //try阶段，库存可用减少，占用增加
        log.info("tryDeduct start ...");
        storageMapper.tryDeduct(commodityCode, count);
        log.info("tryDeduct end ...");
        return Boolean.TRUE;
    }

    @Override
    public Boolean confirmDeduct(BusinessActionContext context) {
        //从上下文中取出try阶段的参数，confirm阶段，可用库存不变，占用扣减
        log.info("confirmDeduct start ...");
        String commodityCode = (String) context.getActionContext().get("commodityCode");
        Integer count = (Integer) context.getActionContext().get("count");
        storageMapper.confirmDeduct(commodityCode, count);
        log.info("confirmDeduct end ...");
        return Boolean.TRUE;
    }

    @Override
    public Boolean cancelDeduct(BusinessActionContext context) {
        //从上下文中取出try阶段的参数，cancel阶段，可用库存增加，占用扣减
        log.info("cancelDeduct start ...");
        String commodityCode = (String) context.getActionContext().get("commodityCode");
        Integer count = (Integer) context.getActionContext().get("count");
        storageMapper.cancelDeduct(commodityCode, count);
        log.info("cancelDeduct end ...");
        return Boolean.TRUE;
    }
}

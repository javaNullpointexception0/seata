package com.lzj.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * TCC模式接口，TCC接口包括三个方法：try、confirm、cancel，所以每个TCC接口，都需要定义该三个方法
 */
@LocalTCC
public interface TccStorageService {

    /**
     * Tcc模式接口，属于事务的try阶段
     * @param commodityCode
     * @param count
     * @return
     */
    @TwoPhaseBusinessAction(name="SEATA-TCC-DEDUCT-STORAGE", commitMethod = "confirmDeduct", rollbackMethod = "cancelDeduct")
    Boolean tryDeduct(@BusinessActionContextParameter(paramName = "commodityCode") String commodityCode,
                      @BusinessActionContextParameter(paramName = "count") int count);

    /**
     * 事务提交方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如tryDeduct接口中的commodityCode和count参数
     * @return
     */
    Boolean confirmDeduct(BusinessActionContext context);

    /**
     * 事务回滚方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如tryDeduct接口中的commodityCode和count参数
     * @return
     */
    Boolean cancelDeduct(BusinessActionContext context);
}

package com.lzj.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface TccAccountService {

    /**
     * Tcc模式接口，属于事务的try阶段
     * @param userId
     * @param money
     * @return
     */
    @TwoPhaseBusinessAction(name="SEATA-TCC-DECREASE-ACCOUNT", commitMethod = "confirmDecrease", rollbackMethod = "cancelDecrease")
    Boolean tryDecrease(@BusinessActionContextParameter(paramName = "userId") String userId,
                        @BusinessActionContextParameter(paramName = "money") int money);

    /**
     * 事务提交方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如tryDecrease接口中的userId和money参数
     * @return
     */
    Boolean confirmDecrease(BusinessActionContext context);

    /**
     * 事务回滚方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如tryDecrease接口中的userId和money参数
     * @return
     */
    Boolean cancelDecrease(BusinessActionContext context);
}

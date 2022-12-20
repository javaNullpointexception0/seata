package com.lzj.service;

import com.lzj.entity.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * TCC模式接口，TCC接口包括三个方法：try、confirm、cancel，所以每个TCC接口，都需要定义该三个方法
 */
@LocalTCC
public interface TccOrderService {

    /**
     * Tcc模式接口，属于事务的try阶段
     * @param order
     * @return
     */
    @TwoPhaseBusinessAction(name="SEATA-TCC-CREATE-ORDER", commitMethod = "confirmOrder", rollbackMethod = "cancelOrder")
    Integer tryCreate(@BusinessActionContextParameter(paramName = "order") Order order);

    /**
     * 事务提交方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如create接口中的order参数
     * @return
     */
    Integer confirmOrder(BusinessActionContext context);

    /**
     * 事务回滚方法
     * @param context seata上下文，可以从上下文中取到Tcc接口的参数，如create接口中的order参数
     * @return
     */
    Integer cancelOrder(BusinessActionContext context);
}

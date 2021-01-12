package com.lzj.common.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeataRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotEmpty(xid)) {
            requestTemplate.header(RootContext.KEY_XID, xid);
        }
    }
}

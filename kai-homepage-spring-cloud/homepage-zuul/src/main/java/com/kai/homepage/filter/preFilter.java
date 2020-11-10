package com.kai.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * FileName:preFilter
 * Author: kaishen
 * Date: 2020/11/7 22:23
 * Description:
 */
@Component
public class preFilter extends ZuulFilter {
    //设置过滤器的类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //过滤器的执行顺序，越小越高
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否启用当前过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //RequestContext 用于在过滤器之间传递消息
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}

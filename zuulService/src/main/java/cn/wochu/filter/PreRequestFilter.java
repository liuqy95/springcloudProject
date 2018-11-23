package cn.wochu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class PreRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        String requestURI = RequestContext.getCurrentContext().getRequest().getRequestURI();
        if(requestURI.contains("orders/orderAdd")){
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String authStr = request.getHeader("jwt");
        if(StringUtils.isBlank(authStr)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.addZuulResponseHeader("content-type","application/json;charset=utf-8");
            requestContext.setResponseBody("非法访问。。。。。。。。。");
        }
        return null;
    }
}

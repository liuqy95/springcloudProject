package cn.wochu.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.io.IOException;
import java.io.InputStream;

public class RecodeNoteFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.DEBUG_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        /**第一种实现方法**/
        /*Object zuulResponse = RequestContext.getCurrentContext().get("zuulResponse");
        if (null != zuulResponse){
            RibbonHttpResponse ribbonHttpResponse = (RibbonHttpResponse) zuulResponse;
            String body = null;
            try {
                body = IOUtils.toString(ribbonHttpResponse.getBody(),"utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("response body is --> " + body);
            ribbonHttpResponse.close();
            RequestContext.getCurrentContext().setResponseBody(body);
        }*/

        /**第二种实现方法**/
        InputStream inputStream = RequestContext.getCurrentContext().getResponseDataStream();
        try {
            String body = IOUtils.toString(inputStream,"utf-8");
            System.out.println("response body is --> " + body);
            RequestContext.getCurrentContext().setResponseBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

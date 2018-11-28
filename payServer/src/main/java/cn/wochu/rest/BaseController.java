package cn.wochu.rest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    private ServletRequestAttributes getServletRequestAttributes(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes;
    }

    protected HttpServletRequest getHttpServletRequest(){
        HttpServletRequest request = getServletRequestAttributes().getRequest();
        return request;
    }

    protected HttpServletResponse getHttpServletResponse(){
        HttpServletResponse response = getServletRequestAttributes().getResponse();
        return response;
    }

}

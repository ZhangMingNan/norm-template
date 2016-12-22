package com.neusoft.norm.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 作者: 张明楠 创建于 16/12/19.
 */
public class HttpRequestUtils {
    /**
     * 获取当前线程的请求
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    private static final String  X_REQUESTED_WITH = "X-Requested-With";
    private static final String  XML_HTTP_REQUEST = "XMLHttpRequest";
    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader(X_REQUESTED_WITH);
        return requestedWith != null ? XML_HTTP_REQUEST.equals(requestedWith) : false;
    }

}

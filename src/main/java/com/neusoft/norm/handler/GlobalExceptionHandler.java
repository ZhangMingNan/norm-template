package com.neusoft.norm.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neusoft.norm.domain.result.HttpResult;
import com.neusoft.norm.utils.HttpRequestUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者: 张明楠 创建于 16/12/13.
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {



    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView errorView = new ModelAndView("/error/500");
        ModelAndView unauthorizedView = new ModelAndView("/admin/unauthorized");
        if (e instanceof UnauthorizedException) {
            if (HttpRequestUtils.isAjaxRequest(httpServletRequest)){
                HttpResult result = HttpResult.fail("当前用户没有此操作权限:"+httpServletRequest.getRequestURI());
                try {
                    String r = objectMapper.writeValueAsString(result);
                    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    httpServletResponse.getWriter().print(r);
                    httpServletResponse.flushBuffer();
                    return new ModelAndView();
                } catch (Exception exception) {
                    logger.error("捕获到异常:",exception);
                }
            }
            return unauthorizedView;
        }
        if (e instanceof MyBatisSystemException) {
            errorView.addObject("errorMsg",e.getLocalizedMessage());
            return errorView;
        }
        logger.error("捕获到异常:",e);
        return errorView;
    }
}

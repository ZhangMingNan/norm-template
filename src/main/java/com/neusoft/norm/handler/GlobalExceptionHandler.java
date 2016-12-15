package com.neusoft.norm.handler;

import org.apache.shiro.authz.UnauthorizedException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者: 张明楠 创建于 16/12/13.
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView errorView = new ModelAndView("/error/500");
        ModelAndView unauthorizedView = new ModelAndView("/admin/unauthorized");
        if (e instanceof UnauthorizedException) {
            return unauthorizedView;
        }
        if (e instanceof MyBatisSystemException) {
            errorView.addObject("errorMsg",e.getLocalizedMessage());
            return errorView;
        }
        return errorView;
    }
}

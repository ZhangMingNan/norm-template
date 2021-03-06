package com.neusoft.norm.controller;

import com.google.common.base.Charsets;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.web.SearchPropertiesEditor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 作者: 张明楠 创建于 16/8/16.
 */
public class BaseController {
    public String redirect(String target) {
        return String.format("redirect:%s", target);
    }

    protected String redirectToMsg(String url, String msg) {
        return String.format("redirect:/msg/info.html?msg=%s&url=%s", encode(msg), encode(url));
    }

    protected String redirectAndClose(String id) {
        return String.format("redirect:/msg/info.html?callback=close_dialog(\"" + id + "\")");
    }

    protected String encode(String string) {
        if (StringUtils.isBlank(string)) {
            return StringUtils.EMPTY;
        }
        try {
            return URLEncoder.encode(string, Charsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
        }
        return StringUtils.EMPTY;
    }


    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(SearchParams.class, new SearchPropertiesEditor());
    }

}

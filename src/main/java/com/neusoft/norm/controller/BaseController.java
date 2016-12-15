package com.neusoft.norm.controller;

import com.google.common.base.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 作者: 张明楠 创建于 16/8/16.
 */
public class BaseController {
    public String redirect(String target) {
        return String.format("redirect:%s", target);
    }

    //操作成功后显示消息提示页面,
    protected String redirectToMsg(String url, String msg) {
        return String.format("redirect:/msg/info.html?msg=%s&url=%s", encode(msg), encode(url));
    }


    protected String encode(String string) {
        if (StringUtils.isBlank(string)) return "";
        try {
            return URLEncoder.encode(string, Charsets.UTF_8.displayName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}

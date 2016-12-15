package com.neusoft.norm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("msg")
public class AdminMsgController extends BaseController {

    /**
     * 操作成功消息页面
     * @param msg
     * @param url
     * @param model
     * @return
     */
    @GetMapping("info.html")
    public String msg(String msg,String url, Model model)   {
        model.addAttribute("msg", msg);
        model.addAttribute("url", url);
        return "/admin/msg";
    }

}

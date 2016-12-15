package com.neusoft.norm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者: 张明楠 创建于 16/12/13.
 */
@Controller
@RequestMapping("error")
public class ErrorController {

    /**
     * 根据错误代码跳转页面
     * @param code
     * @return
     */
    @GetMapping("{code}.html")
    private String error(@PathVariable String code) {
        return String.format("error/%s", code);
    }
}

package com.neusoft.norm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.norm.domain.Dict;
import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 作者: 张明楠 创建于 17/1/16.
 */
@Controller
@RequestMapping("admin")
public class DictController {


    @Autowired
    DictService dictService;

    @RequestMapping("dict/list.html")
    public String dictList(SearchParams searchParams, Model model) {
        PageHelper.startPage(searchParams.getPageRequest().getPageNum(), searchParams.getPageRequest().getPageSize());
        List<Dict> dictList = dictService.findAll(searchParams);
        PageInfo<Dict> pageInfo = new PageInfo<>(dictList);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/dict-list";
    }
}

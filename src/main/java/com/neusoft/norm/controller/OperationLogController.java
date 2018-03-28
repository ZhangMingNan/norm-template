package com.neusoft.norm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.service.OperationLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 作者: 张明楠 创建于 16/12/16.
 */
@Controller
@RequestMapping("admin/log")
public class OperationLogController extends BaseController {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 操作日志列表
     *
     * @param
     * @param model
     * @return
     */
    @GetMapping("list.html")
    @RequiresPermissions("admin:log:list")
    public String list(SearchParams searchParams, Model model, OperationLog operationLog) {
        PageHelper.startPage(searchParams.getPageRequest().getPageNum(), searchParams.getPageRequest().getPageSize());
        List<OperationLog> adminList = operationLogService.findAll(searchParams);
        PageInfo<OperationLog> pageInfo = new PageInfo<>(adminList);
        model.addAttribute("pageInfo", pageInfo);
        return "log/log-list";
    }

}

package com.neusoft.norm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.OperationLog;
import com.neusoft.norm.domain.vo.PageRequest;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.service.OperationLogService;
import jodd.util.ClassLoaderUtil;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

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

package com.neusoft.norm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.result.HttpResult;
import com.neusoft.norm.domain.vo.PageRequest;
import com.neusoft.norm.domain.vo.SearchParams;
import com.neusoft.norm.service.AdminService;
import com.neusoft.norm.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/31.
 */
@Controller
@RequestMapping("admin/manage")
public class AdminManageController extends BaseController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    /**
     * 角色成员管理
     *
     * @param model
     * @return
     */
    @GetMapping
    @RequiresPermissions("admin:manage:list")
    public String list(Admin admin, SearchParams searchParams, Model model, @RequestParam(defaultValue = "0") Integer f) {
        PageHelper.startPage(searchParams.getPageRequest().getPageNum(),searchParams.getPageRequest().getPageSize());
        List<Admin> adminList = adminService.selectAdmins(admin);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
        model.addAttribute("f", f);
        model.addAttribute("pageInfo", pageInfo);
        return "adminManage/admin-list";
    }

    @GetMapping("edit")
    @RequiresPermissions("admin:manage:edit")
    public String edit(Integer userid, Model model) {
        List<AdminRole> roleList = roleService.selectDisabledRole(0);
        Admin admin = adminService.selectAdminByUserId(userid);
        model.addAttribute("admin", admin);
        model.addAttribute("roleList", roleList);
        return "adminManage/admin-edit";
    }

    @GetMapping("add")
    @RequiresPermissions("admin:manage:add")
    public String add(Integer userid, Model model) {
        List<AdminRole> roleList = roleService.selectDisabledRole(0);
        model.addAttribute("roleList", roleList);
        return "adminManage/admin-add";
    }

    @PostMapping("update")
    @RequiresPermissions("admin:manage:update")
    public String updateAdmin(Admin admin, final RedirectAttributes attributes) {
        adminService.updateAdmin(admin);
        //提交表单后重定向到列表页
        return redirectAndClose(admin.getUserid() == null ? "add" : "edit");
    }


    @GetMapping("delete")
    @ResponseBody
    @RequiresPermissions("admin:manage:delete")
    public HttpResult delete(Integer userid, Model model) {
        adminService.deleteByUserid(userid);
        return HttpResult.success();
    }
}


























package com.neusoft.norm.controller;

import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.result.HttpResult;
import com.neusoft.norm.domain.vo.PrivTreeNode;
import com.neusoft.norm.domain.vo.RoleListOrderVO;
import com.neusoft.norm.service.AdminService;
import com.neusoft.norm.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/29.
 */
@Controller
@RequestMapping("admin/role")
public class RoleControler extends BaseController{
    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    /**
     * 角色管理列表
     * @param session
     * @param request
     * @param model
     * @return
     */
    @GetMapping
    @RequiresPermissions("admin:role:list")
    public String role(HttpSession session, HttpServletRequest request, Model model) {
        model.addAttribute("subnav", 1);
        List<AdminRole> roleList = roleService.selectDisabledRole(-1);
        model.addAttribute("roleList", roleList);

        return "admin/role";
    }

    /**
     * 添加角色
     *
     * @param session
     * @param request
     * @param model
     * @return
     */
    @GetMapping("add")
    @RequiresPermissions("admin:role:add")
    public String add(HttpSession session, HttpServletRequest request, Model model) {
        model.addAttribute("subnav", 2);
        return "admin/role_add";
    }

    @PostMapping("add")
    @RequiresPermissions("admin:role:add")
    public String doAdd(AdminRole role){
        roleService.addRole(role);
        return  redirect("/admin/role");
    }

    /**
     * 修改角色内容
     * @param roleid
     * @return
     */
    @GetMapping("edit")
    @RequiresPermissions("admin:role:edit")
    public String edit(Integer roleid,Model model){
        AdminRole role = roleService.selectRoleById(roleid);
        model.addAttribute("role",role);
        return "admin/role_edit";
    }

    /**
     * 保存角色修改信息
     * @param role
     * @return
     */
    @PostMapping("edit")
    @RequiresPermissions("admin:role:edit")
    public String doEdit(AdminRole role,String dialogId,RedirectAttributes attributes){
        roleService.updateRole(role);

        attributes.addAttribute("dialogId", "edit_role");
        return redirect("/admin/closeDialog");
    }


    /**
     * 删除角色
     * @param roleid
     * @return
     */
    @GetMapping("delete")
    @ResponseBody
    @RequiresPermissions("admin:role:delete")
    public HttpResult delete(Integer roleid){

        roleService.deleteRoleById(roleid);
        return  HttpResult.success();
    }


    /**
     * 执行页面排序操作
     * @param vo
     * @return
     */
    @PostMapping("listorders")
    public String listorders(RoleListOrderVO vo) {
        adminService.sorting(vo.listorders);

        return redirectToMsg("/admin/role", "排序成功!");
    }

    @GetMapping("priv")
    public String rolePriv(HttpSession session, HttpServletRequest request, Model model,Integer roleid) {

        model.addAttribute("roleid",roleid);
        return "admin/role_priv";
    }


    /**
     * 根据角色ID获取权限数据
     * @param roleid
     * @return
     */
    @GetMapping("privData")
    @ResponseBody
    public List<PrivTreeNode> rolePrivData(Integer roleid){
        List<PrivTreeNode> menus = roleService.rolePrivById(roleid);
        return  menus;
    }

    /**
     * 根据角色ID设置权限列表
     * @param roleid
     * @param privList
     * @return
     */
    @PostMapping("settingPriv")
    @ResponseBody
    public HttpResult settingPriv(Integer roleid, @RequestParam("privList")List<Integer> privList){
        roleService.settingPriv(roleid,privList);
        return HttpResult.success();
    }


    /**
     * 改变角色可用状态
     * @param role
     * @return
     */
    @GetMapping("changeStatus")
    public String changeStatus(AdminRole role){
        roleService.updateRole(role);
        return redirectToMsg("/admin/role", "设置成功!");
    }

}









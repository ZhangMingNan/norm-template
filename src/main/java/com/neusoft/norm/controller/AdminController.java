package com.neusoft.norm.controller;

import com.neusoft.norm.domain.Menu;
import com.neusoft.norm.domain.result.HttpResult;
import com.neusoft.norm.service.AdminService;
import com.neusoft.norm.shiro.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/4.
 */
@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {


    @Autowired
    AdminService adminService;


    /**
     * 权限拒绝页面
     * @return
     */
    @GetMapping("unauthorized.html")
    public String unauthorized(){
        return "/admin/unauthorized";
    }

    /**
     * 后台登录页面
     * @param request
     * @param username
     * @param password
     * @return
     */
    @GetMapping("login.html")
    public String login(HttpServletRequest request, String username, String password) {

        return "admin/login";
    }

    @GetMapping("logout.html")
    public String logout(){
        Subject subject = ShiroUtils.getSubject();
        subject.logout();
        return redirect("/admin/login.html");
    }


    @PostMapping("login.do")
    public String loginDo(String username, String password) {
        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            //password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return redirectToMsg("/admin/login.html",e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return redirectToMsg("/admin/login.html",e.getMessage());
        } catch (LockedAccountException e) {
            return redirectToMsg("/admin/login.html",e.getMessage());
        } catch (AuthenticationException e) {
            return redirectToMsg("/admin/login.html",e.getMessage());
        }

        return redirectToMsg("/admin","登录成功!");
    }


    @RequestMapping
    public String index(HttpSession session, HttpServletRequest request, Model model) {
        model.addAttribute("topMenus", adminService.selectTopMenu());
        return "admin/index";
    }

    @GetMapping("menuLeft")
    public String menuLeft(int pid, Model model) {
        List<Menu> menus = adminService.selectLeftMenuByParentId(pid);
        model.addAttribute("menus", menus);
        return "admin/menu_left";
    }

    @GetMapping("main")
    public String mian(HttpSession session, HttpServletRequest request, Model model) {
        System.out.println(System.getProperty("system.project_name"));
        return "admin/main";
    }

    @GetMapping("closeDialog")
    public String closeDialog(String dialogId, Model model) {

        model.addAttribute("dialogId", dialogId);
        return "/admin/closeDialog";
    }


    /**
     * 获取菜单层级根据ID
     *
     * @param menuId
     * @return
     */
    @GetMapping("currentPos")
    @ResponseBody
    public HttpResult currentPos(@RequestParam(defaultValue = "0") Integer menuId) {
        String pos = adminService.currentPos(menuId);
        HttpResult result =  HttpResult.success();
        result.setData(StringUtils.removeEnd(pos,">"));
        return  result;
    }

}





















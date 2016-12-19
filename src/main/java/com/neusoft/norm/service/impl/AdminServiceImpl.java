package com.neusoft.norm.service.impl;

import com.google.common.base.Joiner;
import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.Menu;
import com.neusoft.norm.log.annotations.Log;
import com.neusoft.norm.mapper.AdminMapper;
import com.neusoft.norm.mapper.AdminRoleMapper;
import com.neusoft.norm.mapper.MenuMapper;
import com.neusoft.norm.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/15.
 */
@Service
public class AdminServiceImpl  implements AdminService{
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    AdminRoleMapper adminRoleMapper;

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Menu> selectLeftMenuByParentId(int pid) {
        return menuMapper.selectLeftMenuByParentId(pid);
    }

    @Override
    public List<Menu> selectTopMenu() {
        return menuMapper.selectTopMenu();
    }



    @Override
    public void sorting(List<AdminRole> roleList) {
        adminRoleMapper.sorting(roleList);
    }

    @Override
    public List<Admin> selectAdminsByRoleId(Integer roleid) {
        return adminMapper.selectAdminsByRoleId(roleid);
    }

    @Override
    public Admin selectAdminByUserId(Integer userid) {

        return adminMapper.selectByPrimaryKey(userid);
    }


    @Log("更新管理员")
    @Override
    public void updateAdmin(Admin admin) {
        if (admin!=null){
            if (admin.getUserid()==null){
                //新增
                adminMapper.insert(admin);
            }else{
                //更新
                adminMapper.updateByPrimaryKeySelective(admin);
            }
        }
    }


    @Override
    public List<Admin> selectAdmins(Admin admin) {

        return adminMapper.selectAdmins(admin);
    }



    @Override
    public String currentPos(Integer menuId) {
        Menu menu = menuMapper.selectByPrimaryKey(menuId.shortValue());
        StringBuilder sb = new StringBuilder();
        if (menu.getParentid()!=0){
            sb = new StringBuilder(currentPos(menu.getParentid().intValue()));
        }
        sb.append(menu.getName());
        String separator = ">";
        sb.append(separator);
        return sb.toString();
    }

    @Override
    public Admin selectByUserName(String username) {
        return adminMapper.selectByUserName(username);
    }

    @Override
    public List<String> findPermissionsByRoleid(Integer roleid) {
        return adminMapper.findPermissionsByRoleid(roleid);
    }

    @Log("删除管理员")
    @Override
    public void deleteByUserid(Integer userid) {

        adminMapper.deleteByPrimaryKey(userid);
    }

}

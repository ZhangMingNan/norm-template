package com.neusoft.norm.service;

import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.Menu;

import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/15.
 */
public interface AdminService {
    List<Menu> selectLeftMenuByParentId(int pid, Short roleid);

    List<Menu> selectTopMenu(Short roleid);

    void sorting(List<AdminRole> roleList);
    List<Admin> selectAdminsByRoleId(Integer roleid);

    Admin selectAdminByUserId(Integer userid);

    void updateAdmin(Admin admin);

    List<Admin> selectAdmins(Admin admin);

    String currentPos(Integer menuId);

    Admin selectByUserName(String username);

    List<String> findPermissionsByRoleid(Integer roleid);

    void deleteByUserid(Integer userid);
}

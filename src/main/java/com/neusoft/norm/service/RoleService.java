package com.neusoft.norm.service;

import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.vo.PrivTreeNode;

import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/28.
 */
public interface RoleService {
    List<PrivTreeNode> rolePrivById(Integer roleId);
    void settingPriv(Integer roleId, List<Integer> privList);

    List<AdminRole> selectDisabledRole(int disabled);

    void updateRole(AdminRole role);

    AdminRole selectRoleById(Integer roleid);

    void deleteRoleById(Integer roleid);

    void addRole(AdminRole role);
}

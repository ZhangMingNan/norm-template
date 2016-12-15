package com.neusoft.norm.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.neusoft.norm.domain.AdminRole;
import com.neusoft.norm.domain.AdminRolePriv;
import com.neusoft.norm.domain.Menu;
import com.neusoft.norm.domain.vo.PrivTreeNode;
import com.neusoft.norm.mapper.AdminRoleMapper;
import com.neusoft.norm.mapper.AdminRolePrivMapper;
import com.neusoft.norm.mapper.MenuMapper;
import com.neusoft.norm.service.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/28.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    AdminRoleMapper adminRoleMapper;

    @Override
    public List<PrivTreeNode> rolePrivById(Integer roleid) {
        List<PrivTreeNode> nodes = Lists.newArrayList();

        //所有的菜单
        List<Menu> menuList = menuMapper.selectDisableMenu();
        //当前角色的菜单
        List<AdminRolePriv> rolePrivList = adminRolePrivMapper.selectRolePrivById(roleid);


        Collection<Integer> rolePrivIds = Collections2.transform(rolePrivList, new Function<AdminRolePriv, Integer>() {
            @Override
            public Integer apply(AdminRolePriv input) {
                return input.getMenuid();
            }
        });


        for (Menu menu : menuList) {
            PrivTreeNode node = new PrivTreeNode();
            node.setId(Integer.valueOf(menu.getId()));
            node.setName(menu.getName());
            node.setIsParent(menu.getParentid() == 0);
            node.setpId(Integer.valueOf(menu.getParentid()));
            nodes.add(node);
            node.setChecked(rolePrivIds.contains(Integer.valueOf(menu.getId())));

            //如果已经选中,并且是顶级节点.
            if (node.getChecked() && node.getIsParent()) {
                node.setOpen(true);
            }

        }

        return nodes;
    }

    @Autowired
    AdminRolePrivMapper adminRolePrivMapper;

    @Override
    public void settingPriv(Integer roleid, List<Integer> privList) {
        //首先清空这个角色下的所有权限列表
        adminRolePrivMapper.deleteRolePrivByRoleId(roleid);
        if (!CollectionUtils.isEmpty(privList)) {
            //插入新设置的角色对应的菜单记录
            adminRolePrivMapper.settingPriv(roleid, privList);
        }
    }

    @Override
    public List<AdminRole> selectDisabledRole(int disabled) {
        return adminRoleMapper.selectDisabledRole(disabled);
    }

    @Override
    public void updateRole(AdminRole role) {
        adminRoleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public AdminRole selectRoleById(Integer roleid) {
        return adminRoleMapper.selectByPrimaryKey(roleid.byteValue());
    }

    @Override
    public void deleteRoleById(Integer roleid) {
        adminRoleMapper.deleteByPrimaryKey(roleid.byteValue());
    }

    @Override
    public void addRole(AdminRole role) {
        adminRoleMapper.insert(role);
    }
}

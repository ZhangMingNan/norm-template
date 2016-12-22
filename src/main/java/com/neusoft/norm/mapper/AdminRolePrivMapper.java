package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.AdminRolePriv;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface AdminRolePrivMapper {
    int insert(AdminRolePriv record);

    int insertSelective(AdminRolePriv record);

    /**
     * 根据角色ID删除权限列表
     * @param roleid
     */
    void deleteRolePrivByRoleId(@Param("roleid")Integer roleid);

    /**
     * 设置角色的权限清单
     * @param roleid
     * @param menuList
     */
    void settingPriv(@Param("roleid")Integer roleid,@Param("menuList") ArrayList<Integer> menuList);

    /**
     * 根据角色ID查询权限列表
     * @param roleid
     * @return
     */
    List<AdminRolePriv> selectRolePrivById(@Param("roleid") Integer roleid);

}
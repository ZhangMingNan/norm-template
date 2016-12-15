package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAdminsByRoleId(Integer roleid);

    List<Admin> selectAdmins(Admin admin);

    Admin selectByUserName(String username);

    List<String> findPermissionsByRoleid(Integer roleid);
}
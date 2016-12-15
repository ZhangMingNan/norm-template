package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.Admin;
import com.neusoft.norm.domain.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Byte roleid);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Byte roleid);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKeyWithBLOBs(AdminRole record);

    int updateByPrimaryKey(AdminRole record);

    List<AdminRole> selectDisabledRole(@Param("disabled") Integer disabled);

    void sorting(@Param("roleList") List<AdminRole> roleList);


}
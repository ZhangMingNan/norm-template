package com.neusoft.norm.mapper;

import com.neusoft.norm.domain.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectLeftMenuByParentId(int pid);

    List<Menu> selectTopMenu(Short roleid);

    List<Menu> selectDisableMenu();
}
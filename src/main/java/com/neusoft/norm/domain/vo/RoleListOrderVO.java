package com.neusoft.norm.domain.vo;

import com.neusoft.norm.domain.AdminRole;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 张明楠 创建于 16/8/25.
 */
@ToString
public class RoleListOrderVO {
    public List<AdminRole> listorders = new ArrayList<AdminRole>();

    public RoleListOrderVO(ArrayList<AdminRole> listorders) {
        this.listorders = listorders;
    }

    public RoleListOrderVO() {
        super();
    }

    public List<AdminRole> getListorders() {
        return listorders;
    }

    public void setListorders(List<AdminRole> listorders) {
        this.listorders = listorders;
    }
}

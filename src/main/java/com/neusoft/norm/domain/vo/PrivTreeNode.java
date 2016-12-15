package com.neusoft.norm.domain.vo;

import lombok.ToString;

/**
 * 权限树的节点
 * 作者: 张明楠 创建于 16/8/28.
 */
@ToString
public class PrivTreeNode {
    private Integer id;
    private Integer pId;
    private String name;
    private Boolean open = false;
    private Boolean isParent = true;
    private Boolean checked = false;


    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}

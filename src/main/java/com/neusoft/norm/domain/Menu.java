package com.neusoft.norm.domain;

import java.util.List;

public class Menu {
    private Short id;

    private String name;

    private Short parentid;

    private String resource;

    private String data;

    private Short listorder;

    private String display;

    private List<Menu> subMenus;

    //shiro 权限标记列表
    private  String permissions;

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getParentid() {
        return parentid;
    }

    public void setParentid(Short parentid) {
        this.parentid = parentid;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Short getListorder() {
        return listorder;
    }

    public void setListorder(Short listorder) {
        this.listorder = listorder;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display == null ? null : display.trim();
    }
}
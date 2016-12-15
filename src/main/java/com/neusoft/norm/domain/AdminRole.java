package com.neusoft.norm.domain;

public class AdminRole {
    private Byte roleid;

    private String rolename;

    private Short listorder;

    private Boolean disabled;

    private String description;

    public Byte getRoleid() {
        return roleid;
    }

    public void setRoleid(Byte roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Short getListorder() {
        return listorder;
    }

    public void setListorder(Short listorder) {
        this.listorder = listorder;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
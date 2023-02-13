package com.zym.pojo;

import java.util.List;

public class AdminType {
    private Integer id;
    private String admin_type_name;
    private Integer admin_type_id;
    private List<Admin> adminList;

    public AdminType() {
    }

    public AdminType(Integer id, String admin_type_name, Integer admin_type_id, List<Admin> adminList) {
        this.id = id;
        this.admin_type_name = admin_type_name;
        this.admin_type_id = admin_type_id;
        this.adminList = adminList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin_type_name() {
        return admin_type_name;
    }

    public void setAdmin_type_name(String admin_type_name) {
        this.admin_type_name = admin_type_name;
    }

    public Integer getAdmin_type_id() {
        return admin_type_id;
    }

    public void setAdmin_type_id(Integer admin_type_id) {
        this.admin_type_id = admin_type_id;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public String toString() {
        return "AdminType{" +
                "id=" + id +
                ", admin_type_name='" + admin_type_name + '\'' +
                ", admin_type_id=" + admin_type_id +
                ", adminList=" + adminList +
                '}';
    }
}

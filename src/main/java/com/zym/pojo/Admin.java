package com.zym.pojo;

public class Admin {
    private Integer a_Id;
    private String a_Name;
    private String a_Pass;
    private Integer admin_type_id;
    public Admin() {
    }

    public Admin(Integer a_Id, String a_Name, String a_Pass, Integer admin_type_id) {
        this.a_Id = a_Id;
        this.a_Name = a_Name;
        this.a_Pass = a_Pass;
        this.admin_type_id = admin_type_id;
    }

    public Integer getA_Id() {
        return a_Id;
    }

    public void setA_Id(Integer a_Id) {
        this.a_Id = a_Id;
    }

    public String getA_Name() {
        return a_Name;
    }

    public void setA_Name(String a_Name) {
        this.a_Name = a_Name;
    }

    public String getA_Pass() {
        return a_Pass;
    }

    public void setA_Pass(String a_Pass) {
        this.a_Pass = a_Pass;
    }

    public Integer getAdmin_type_id() {
        return admin_type_id;
    }

    public void setAdmin_type_id(Integer admin_type_id) {
        this.admin_type_id = admin_type_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_Id=" + a_Id +
                ", a_Name='" + a_Name + '\'' +
                ", a_Pass='" + a_Pass + '\'' +
                ", admin_type_id=" + admin_type_id +
                '}';
    }
}

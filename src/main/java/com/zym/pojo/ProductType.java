package com.zym.pojo;

public class ProductType {
    private Integer type_Id;
    private String type_Name;

    public ProductType(Integer type_Id, String type_Name) {
        this.type_Id = type_Id;
        this.type_Name = type_Name;
    }

    public ProductType() {
    }

    public Integer getType_Id() {
        return type_Id;
    }

    public void setType_Id(Integer type_Id) {
        this.type_Id = type_Id;
    }

    public String getType_Name() {
        return type_Name;
    }

    public void setType_Name(String type_Name) {
        this.type_Name = type_Name;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "type_Id=" + type_Id +
                ", type_Name='" + type_Name + '\'' +
                '}';
    }
}

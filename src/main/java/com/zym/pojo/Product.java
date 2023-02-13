package com.zym.pojo;

import java.util.Date;

public class Product {
    private Integer p_Id;
    private String p_Name;
    private String p_Content;
    private Integer p_price;
    private String p_Image;
    private Integer p_Number;
    private Integer type_Id;
    private Date p_Date;

    public Product() {
    }

    public Product(Integer p_Id, String p_Name, String p_Content, Integer p_price, String p_Image, Integer p_Number, Integer type_Id, Date p_Date) {
        this.p_Id = p_Id;
        this.p_Name = p_Name;
        this.p_Content = p_Content;
        this.p_price = p_price;
        this.p_Image = p_Image;
        this.p_Number = p_Number;
        this.type_Id = type_Id;
        this.p_Date = p_Date;
    }

    public Integer getP_Id() {
        return p_Id;
    }

    public void setP_Id(Integer p_Id) {
        this.p_Id = p_Id;
    }

    public String getP_Name() {
        return p_Name;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public String getP_Content() {
        return p_Content;
    }

    public void setP_Content(String p_Content) {
        this.p_Content = p_Content;
    }

    public Integer getP_price() {
        return p_price;
    }

    public void setP_price(Integer p_price) {
        this.p_price = p_price;
    }

    public String getP_Image() {
        return p_Image;
    }

    public void setP_Image(String p_Image) {
        this.p_Image = p_Image;
    }

    public Integer getP_Number() {
        return p_Number;
    }

    public void setP_Number(Integer p_Number) {
        this.p_Number = p_Number;
    }

    public Integer getType_Id() {
        return type_Id;
    }

    public void setType_Id(Integer type_Id) {
        this.type_Id = type_Id;
    }

    public Date getP_Date() {
        return p_Date;
    }

    public void setP_Date(Date p_Date) {
        this.p_Date = p_Date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_Id=" + p_Id +
                ", p_Name='" + p_Name + '\'' +
                ", p_Content='" + p_Content + '\'' +
                ", p_price=" + p_price +
                ", p_Image='" + p_Image + '\'' +
                ", p_Number=" + p_Number +
                ", type_Id=" + type_Id +
                ", p_Date=" + p_Date +
                '}';
    }
}

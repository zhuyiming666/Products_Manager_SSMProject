package com.zym.pojo;

import java.util.List;

public class OrderDetail {
    private Integer odId;
    private String oId;  //订单编号
    private Integer pId; //产品Id
    private Integer pNumber; //产品数量
    private double pTotal; //产品总价格
    private Order order;
    private List<Product> productList;

    public OrderDetail() {
    }

    public OrderDetail(Integer odId, String oId, Integer pId, Integer pNumber, double pTotal, Order order, List<Product> productList) {
        this.odId = odId;
        this.oId = oId;
        this.pId = pId;
        this.pNumber = pNumber;
        this.pTotal = pTotal;
        this.order = order;
        this.productList = productList;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public double getpTotal() {
        return pTotal;
    }

    public void setpTotal(double pTotal) {
        this.pTotal = pTotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "odId=" + odId +
                ", oId='" + oId + '\'' +
                ", pId=" + pId +
                ", pNumber=" + pNumber +
                ", pTotal=" + pTotal +
                ", order=" + order +
                ", productList=" + productList +
                '}';
    }
}
package com.zym.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {
    private String oId;
    private Integer uId;
    private Integer addressId;
    private double totalPrice;
    private String remarks; //订单备注
    private String status;  //订单状态
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
    private Date oDate;
    private OrderDetail orderDetail;
    private Users users;
    private Address address;

    public Order() {
    }

    public Order(String oId, Integer uId, Integer addressId, double totalPrice, String remarks, String status, Date oDate, OrderDetail orderDetail, Users users, Address address) {
        this.oId = oId;
        this.uId = uId;
        this.addressId = addressId;
        this.totalPrice = totalPrice;
        this.remarks = remarks;
        this.status = status;
        this.oDate = oDate;
        this.orderDetail = orderDetail;
        this.users = users;
        this.address = address;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId='" + oId + '\'' +
                ", uId=" + uId +
                ", addressId=" + addressId +
                ", totalPrice=" + totalPrice +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                ", oDate=" + oDate +
                ", orderDetail=" + orderDetail +
                ", users=" + users +
                ", address=" + address +
                '}';
    }
}

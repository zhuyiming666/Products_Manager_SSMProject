package com.zym.pojo;

public class Address {
    private Integer addressId;
    private Integer uId;    //用户id
    private String cnee;   //收货人
    private String phone;
    private String address;
    private Users users;

    public Address() {
    }

    public Address(Integer addressId, Integer uId, String cnee, String phone, String address, Users users) {
        this.addressId = addressId;
        this.uId = uId;
        this.cnee = cnee;
        this.phone = phone;
        this.address = address;
        this.users = users;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getCnee() {
        return cnee;
    }

    public void setCnee(String cnee) {
        this.cnee = cnee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", uId=" + uId +
                ", cnee='" + cnee + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", users=" + users +
                '}';
    }
}

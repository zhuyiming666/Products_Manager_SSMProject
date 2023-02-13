package com.zym.service;

import com.zym.pojo.Order;
import com.zym.pojo.PageBean;
import com.zym.pojo.Users;

import java.util.List;

public interface UsersService {

    public PageBean<Users> findByPage(int currentPage,String uName,String uStatus,String orderbyId);
    Users getUsersByuId(Integer uId);
    void updateUsers(Users users);
    void deleteUsers(Integer uId);
}

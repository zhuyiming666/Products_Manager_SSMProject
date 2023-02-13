package com.zym.service;

import com.zym.pojo.Order;
import com.zym.pojo.OrderDetail;
import com.zym.pojo.PageBean;
import com.zym.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    int totalCount(String oId,String status);
    public PageBean<Order> findByPage(int currentPage,String oId,String status);
    List<OrderDetail> showOrderDetail(String oId);

}

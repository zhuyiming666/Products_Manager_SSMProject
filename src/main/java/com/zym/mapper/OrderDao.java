package com.zym.mapper;

import com.zym.pojo.Order;
import com.zym.pojo.OrderDetail;
import com.zym.pojo.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface OrderDao {

    int totalCount(@Param("oId") String oId,@Param("status") String status);
    List<Order> showAllOrder(HashMap<String,Object> map);
    List<OrderDetail> showOrderDetail(String oId);
}

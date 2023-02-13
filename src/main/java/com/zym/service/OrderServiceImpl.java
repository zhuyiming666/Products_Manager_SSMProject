package com.zym.service;

import com.zym.mapper.OrderDao;
import com.zym.pojo.Order;
import com.zym.pojo.OrderDetail;
import com.zym.pojo.PageBean;
import com.zym.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public int totalCount(String oId, String status) {
        return orderDao.totalCount(oId,status);
    }

    @Override
    public PageBean<Order> findByPage(int currentPage,String oId,String status) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Order> pageBean=new PageBean<>();

        pageBean.setCurrPage(currentPage);

        int pageSize=3;
        pageBean.setPageSize(pageSize);

        int totalCount= orderDao.totalCount(oId,status);
        pageBean.setTotalCount(totalCount);

        int pageCount;
        if(totalCount%pageSize==0){
            pageCount=totalCount/pageSize;
        }else {
            pageCount=totalCount/pageSize+1;
        }
        pageBean.setTotalPage(pageCount);

        map.put("start",(pageBean.getCurrPage()-1)*pageBean.getPageSize());
        map.put("size",pageBean.getPageSize());
        map.put("oId",oId);
        map.put("status",status);

        List<Order> list=orderDao.showAllOrder(map);
        pageBean.setList(list);
        return pageBean;
    }

    public List<OrderDetail> showOrderDetail(String oId){
        return orderDao.showOrderDetail(oId);
    }


}

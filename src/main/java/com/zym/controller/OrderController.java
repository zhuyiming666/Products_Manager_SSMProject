package com.zym.controller;

import com.zym.pojo.Order;
import com.zym.pojo.OrderDetail;
import com.zym.pojo.PageBean;
import com.zym.pojo.TestAjax;
import com.zym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orderController")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/showAllOrder")
    public String showAllOrder(@RequestParam(value = "currPage",defaultValue = "1",required =false)int currPage, String oIdN, String statusN,
                               HttpServletRequest request){
        PageBean pageBean=orderService.findByPage(currPage,oIdN,statusN);
        request.setAttribute("pageBean",pageBean);
       /* List<Order> list=pageBean.getList();
        for (Order order:list){
            System.out.println(order);
        }*/
        return "/order-list1.jsp";
    }

    @RequestMapping("/showOrderDetail")
    public String showOrderDetail(String oId,HttpServletRequest request){
        List<OrderDetail> orderDetails=orderService.showOrderDetail(oId);
        /*for (OrderDetail orderDetail:orderDetails){
            System.out.println(orderDetail);
        }*/
        request.setAttribute("orderDetails",orderDetails);
        return "/orderdetail-list.jsp";
    }

    @RequestMapping("/showAllOrderAjax")
    public String showAllOrderAjax(String statusN){
        System.out.println(statusN);
        return "/test.jsp";
    }

    @RequestMapping(value = "/showTestAjax",method = RequestMethod.POST)
    @ResponseBody
    public PageBean showTestAjax(@RequestBody TestAjax testAjax){
        PageBean pageBean=orderService.findByPage(testAjax.getCurrPage(),testAjax.getoIdN(),testAjax.getStatusN());
        return pageBean;
    }

    /*@RequestMapping(value = "/showTestAjaxStr",method = RequestMethod.POST)
    @ResponseBody
    public List<OrderDetail> showTestAjaxStr(@RequestParam String oId){
        List<OrderDetail> orderDetails=orderService.showOrderDetail(oId);
        for (OrderDetail orderDetail:orderDetails) {
            System.out.println(orderDetail);
        }
        return orderDetails;
    }*/
}

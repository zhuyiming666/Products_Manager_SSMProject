package com.zym.controller;

import com.zym.pojo.PageBean;
import com.zym.pojo.Users;
import com.zym.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/getUsersAll")
    public String getUsersAll(@RequestParam(value = "currPage",defaultValue = "1",required =false)int currPage,@RequestParam(value = "uName",defaultValue = "",required =false)String uName,String uStatus,String orderbyId,HttpServletRequest request){
        PageBean pageBean=usersService.findByPage(currPage,uName,uStatus,orderbyId);
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("uName",uName);
        request.setAttribute("uStatus",uStatus);
        request.setAttribute("orderby_index",orderbyId);
        return "/users-list.jsp";
    }

    @RequestMapping("/getUsersByuId")
    public String getUsersByuId(Integer uId,HttpServletRequest request){
        Users users=usersService.getUsersByuId(uId);
        request.setAttribute("users",users);
        return "/users-update.jsp";
    }

    @RequestMapping("/updateUsers")
    public String updateUsers(Users users){
        System.out.println(users);
        usersService.updateUsers(users);
        return "/users-list.jsp";
    }

    @RequestMapping("/getDeleteByuId")
    public String deleteUsers(Integer uId){
        System.out.println(uId);
        System.out.println("____________________");
        usersService.deleteUsers(uId);
        return "/users-list.jsp";
    }
}

package com.zym.controller;

import com.zym.pojo.Admin;
import com.zym.service.AdminService;
import com.zym.utils.RandomValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String username, String password,String checkcode,String checkCookie, HttpSession session, HttpServletRequest request,HttpServletResponse response) {
        System.out.println("checkCookie"+checkCookie);
        String s=(String)session.getAttribute("randomcode_key");
        if (!s.equals(checkcode)){
            request.setAttribute("errorMsg", "验证码错误!");
            return "login.jsp";
        }
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            if("on".equals(checkCookie)){
               /* session.setAttribute("SESSION_ADMIN_ID","");
                session.setAttribute("SESSION_ADMIN_USERNAME","");
                session.setAttribute("SESSION_ADMIN_PASSWORD","");*/
                Cookie cookie1=new Cookie("admin_id",admin.getA_Id().toString());
                Cookie cookie2=new Cookie("admin_name",admin.getA_Name());
                Cookie cookie3=new Cookie("admin_pwd",admin.getA_Pass());
                cookie1.setMaxAge(60*60*24*3);
                cookie2.setMaxAge(60*60*24*3);
                cookie3.setMaxAge(60*60*24*3);

                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                cookie3.setPath(request.getContextPath());

                //发送cookie给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);
            }
            return "redirect:design.jsp";
        }
        request.setAttribute("errorMsg", "账号或密码错误");
        return "login.jsp";
    }

    @RequestMapping("getlogin")
    public String getlogin(HttpServletRequest request){
        String a_Id="";
        String a_Name="";
        String a_Pass="";
        Cookie[] cookies=request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (Cookie c:cookies){
                if(c.getName().equals("admin_id")){
                    System.out.println("admin_id-->"+c.getValue());
                    a_Id=c.getValue();
                }
                if(c.getName().equals("admin_name")){
                    System.out.println("admin_name-->"+c.getValue());
                    a_Name=c.getValue();
                }
                if (c.getName().equals("admin_pwd")){
                    System.out.println("admin_pwd-->"+c.getValue());
                    a_Pass=c.getValue();
                }
            }
        }
        request.setAttribute("a_Id",a_Id);
        request.setAttribute("a_Name",a_Name);
        request.setAttribute("a_Pass",a_Pass);
        return "login.jsp";
    }

    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:getlogin";
    }


    @RequestMapping(value = "/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

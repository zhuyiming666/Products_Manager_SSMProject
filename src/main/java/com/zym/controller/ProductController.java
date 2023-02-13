package com.zym.controller;

import com.zym.pojo.PageInfo;
import com.zym.pojo.Product;
import com.zym.pojo.ProductType;
import com.zym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("showAll")
    public String showAll(PageInfo pageInfo, HttpServletRequest request) {
        System.out.println(pageInfo);
        int total=productService.totalCount(pageInfo);
        pageInfo.setTotalCount(total);
        if(pageInfo.getCurrPage()>=pageInfo.getPageCount()){
            pageInfo.setCurrPage(pageInfo.getPageCount());
        }
        List<Product> list=productService.getProducts(pageInfo);
        pageInfo.setArrList(list);
        request.setAttribute("pageInfo",pageInfo);
        return "design.jsp";
    }

    @RequestMapping("/showProductType")
    @ResponseBody
    public List<ProductType> showProductType(HttpServletRequest request){
        List<ProductType> productTypes=productService.getProductType();
        return productTypes;
    }

    @RequestMapping("insertProduct")
    public String insertProduct(Product product){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(product);
        Integer result=productService.insertProdct(product);
        System.out.println(result);
        if (result!=null) {
            return "showAll";
        }
        return "insert.jsp";
    }

    @RequestMapping("deleteProduct")
    public String deleteProduct(Integer pid){
        productService.deleteProduct(pid);
        return "showAll";
    }

    @RequestMapping("selectById")
    public String selectById(Integer pid,Integer currPage,HttpServletRequest request) throws ParseException {
        Product product=productService.selectById(pid);
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String d=sf.format(product.getP_Date());
        request.setAttribute("product",product);
        request.setAttribute("d",d);
        request.setAttribute("currPage1",currPage);
        return "update.jsp";
    }

    @RequestMapping("updateProduct")
    public String updateProduct(Product product,Integer currPage){
        productService.updateProduct(product);
        return "redirect:showAll?currPage="+currPage;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //注册自定义的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("deleteByIds")
    public String deleteByIds(@RequestParam(value = "currPage",defaultValue = "1",required =false)Integer currPage, @RequestParam(value = "msgName",defaultValue = "",required =false)String msgName, @RequestParam(value = "type_Id",defaultValue ="0",required =false)Integer type_Id, @RequestParam(value = "ids",defaultValue ="",required =false)String ids){
        productService.deleteByIds(ids);
        return "showAll?currPage="+currPage+"&msgName="+msgName+"&type_Id="+type_Id+"&ids="+ids;
    }
}

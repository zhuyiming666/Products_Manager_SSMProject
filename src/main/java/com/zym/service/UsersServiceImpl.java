package com.zym.service;

import com.zym.mapper.UsersDao;
import com.zym.pojo.Order;
import com.zym.pojo.PageBean;
import com.zym.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDao usersDao;

    @Override
    public PageBean<Users> findByPage(int currentPage,String uName,String uStatus,String orderbyId) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Users> pageBean=new PageBean<>();

        pageBean.setCurrPage(currentPage);

        int pageSize=3;
        pageBean.setPageSize(pageSize);

        int totalCount=usersDao.totalCount(uName,uStatus);
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
        map.put("uName",uName);
        map.put("uStatus",uStatus);
        map.put("orderbyId",orderbyId);

        List<Users> list=usersDao.showAllOrder(map);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Users getUsersByuId(Integer uId) {
        return usersDao.getUsersByuId(uId);
    }

    @Override
    public void updateUsers(Users users) {
         usersDao.updateUsers(users);
    }

    @Override
    public void deleteUsers(Integer uId) {
        usersDao.deleteUsers(uId);
    }
}

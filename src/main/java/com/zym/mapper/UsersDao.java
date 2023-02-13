package com.zym.mapper;

import com.zym.pojo.Order;
import com.zym.pojo.PageBean;
import com.zym.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface UsersDao {

    int totalCount(@Param("uName")String uName,@Param("uStatus")String uStatus);
    List<Users> showAllOrder(HashMap<String,Object> map);

    Users getUsersByuId(Integer uId);
    void updateUsers(Users users);

    void deleteUsers(Integer uId);
}

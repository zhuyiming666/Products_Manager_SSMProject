package com.zym.mapper;

import com.zym.pojo.Admin;
import com.zym.pojo.Product;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    Admin login(@Param("username")String username, @Param("password") String password); //登录
}

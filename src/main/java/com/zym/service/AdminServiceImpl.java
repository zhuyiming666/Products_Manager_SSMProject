package com.zym.service;

import com.zym.mapper.AdminDao;
import com.zym.pojo.Admin;
import com.zym.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username,password);
    }
}

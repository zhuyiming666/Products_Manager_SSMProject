package com.zym.service;

import com.zym.pojo.Admin;
import com.zym.pojo.Product;

public interface AdminService {

    Admin login(String username, String password);
}

package com.zym.service;

import com.zym.mapper.ProductDao;
import com.zym.pojo.PageInfo;
import com.zym.pojo.Product;
import com.zym.pojo.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public int totalCount(PageInfo pageInfo) {
        return productDao.totalCount(pageInfo);
    }

    @Override
    public List<Product> getProducts(PageInfo pageInfo) {
        return productDao.getProducts(pageInfo);
    }

    @Override
    public List<ProductType> getProductType(){
        return productDao.getProductType();
    }

    @Override
    public Integer deleteProduct(Integer pid) {
        return productDao.deleteProduct(pid);
    }

    @Override
    public Integer insertProdct(Product product) {
        return productDao.insertProdct(product);
    }

    @Override
    public Product selectById(Integer pid) {
        return productDao.selectById(pid);
    }

    @Override
    public Integer updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Integer deleteByIds(String ids) {
        return productDao.deleteByIds(ids);
    }
}

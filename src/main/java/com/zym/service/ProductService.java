package com.zym.service;

import com.zym.pojo.PageInfo;
import com.zym.pojo.Product;
import com.zym.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    int totalCount(PageInfo pageInfo);
    List<Product> getProducts(PageInfo pageInfo);
    List<ProductType> getProductType();
    Integer insertProdct(Product product);
    Integer deleteProduct(Integer pid);
    Product selectById(Integer pid);
    Integer updateProduct(Product product);

    Integer deleteByIds(String ids);
}

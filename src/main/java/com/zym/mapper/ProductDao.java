package com.zym.mapper;

import com.zym.pojo.PageInfo;
import com.zym.pojo.Product;
import com.zym.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    int totalCount(PageInfo pageInfo);
    List<Product> getProducts(PageInfo pageInfo); //分页查询

    List<ProductType> getProductType();
    Integer insertProdct(Product product);

    Integer deleteProduct(Integer pid);

    Product selectById(Integer pid);
    Integer updateProduct(Product product);

    Integer deleteByIds(String ids); //批量删除
}

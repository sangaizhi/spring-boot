package org.sangaizhi.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.sangaizhi.springboot.config.datasource.DatabaseType;
import org.sangaizhi.springboot.config.datasource.DynamicDataSource;
import org.sangaizhi.springboot.mapper.ProductMapper;
import org.sangaizhi.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
@Repository
public class ProductDao  {

    @Autowired
    private ProductMapper productMapper;

    public Product getById(@Param("id") Long id) {
        return productMapper.getById(id);
    }

    public Integer save(Product product){
        return productMapper.save(product);
    }
}

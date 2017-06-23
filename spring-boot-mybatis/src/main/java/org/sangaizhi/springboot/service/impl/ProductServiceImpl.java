package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.ProductDao;
import org.sangaizhi.springboot.model.Product;
import org.sangaizhi.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public Integer save(Product product) {
        return productDao.save(product);
    }
}

package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.ProductDetailDao;
import org.sangaizhi.springboot.model.ProductDetail;
import org.sangaizhi.springboot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    @Override
    public ProductDetail getById(Long id) {
        return productDetailDao.getById(id);
    }

    @Override
    public Integer save(ProductDetail productDetail) {
        return productDetailDao.save(productDetail);
    }
}

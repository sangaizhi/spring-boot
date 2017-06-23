package org.sangaizhi.springboot.dao;

import org.sangaizhi.springboot.model.ProductDetail;

/**
 * created by sangaizhi on 2017/6/23.
 */
public interface ProductDetailDao {

    ProductDetail getById(Long id);
    Integer save(ProductDetail productDetail);
}

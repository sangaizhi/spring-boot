package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.ProductDetail;

/**
 * created by sangaizhi on 2017/6/23.
 */
public interface ProductDetailService {
    ProductDetail getById(Long id);
    Integer save(ProductDetail productDetail);
}

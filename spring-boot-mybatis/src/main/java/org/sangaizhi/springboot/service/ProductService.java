package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.Product;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
public interface ProductService {
    Product getById(Long id);

    Integer save(Product product);
}

package org.sangaizhi.springboot.controller;

import org.sangaizhi.springboot.model.ProductDetail;
import org.sangaizhi.springboot.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
@RestController
@RequestMapping("/pd")
public class ProductDetailCtr {

    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping("/save")
    @ResponseBody
    public ProductDetail save(ProductDetail detail){
        productDetailService.save(detail);
        return detail;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public ProductDetail getById(@PathVariable Long id){
        return productDetailService.getById(id);
    }
}

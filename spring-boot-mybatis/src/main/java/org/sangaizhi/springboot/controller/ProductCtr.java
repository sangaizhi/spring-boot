package org.sangaizhi.springboot.controller;

import org.sangaizhi.springboot.model.Product;
import org.sangaizhi.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
@RestController
@RequestMapping("/product")
public class ProductCtr {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
	public Product getProduct(@PathVariable("id") long id) {
	    Product product = productService.getById(id);
        return product;
	}
	@RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
	public Product save(Product product) {
	    productService.save(product);
        return product;
	}

}

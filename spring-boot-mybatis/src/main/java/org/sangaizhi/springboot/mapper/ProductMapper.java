package org.sangaizhi.springboot.mapper;

import org.apache.ibatis.annotations.*;
import org.sangaizhi.springboot.model.Product;

/**
 * created by sangaizhi on 2017/6/23.
 */
public interface ProductMapper {

	@Select("SELECT * FROM t_product where id=#{id}")
	@Results(value = { @Result(id = true, column = "id", property = "id"),
		@Result(id = true, column = "name", property = "name"),
		@Result(id = true, column = "price", property = "price"),
		@Result(id = true, column = "stock", property = "stock") })
	Product getById(@Param("id") Long id);

	@Insert("INSERT INTO t_product(name,price,stock) values(#{product.name},#{product.price},#{product.stock})")
	Integer save(@Param("product") Product product);
}

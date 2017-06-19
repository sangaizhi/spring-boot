package org.sangaizhi.springboot.jpa.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 自定义 repository
 * @author sangaizhi
 * @date 2017/6/19
 */

/**
 * 注解 @NoRepositoryBean 指明当前这个接口不是我们领域类的接口
 */
@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}

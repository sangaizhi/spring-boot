package org.sangaizhi.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.sangaizhi.springboot.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author sangaizhi
 * @date 2017/7/12
 */
@Repository
public interface UserDao {

    User findByUsername(@Param("name") String name);

}

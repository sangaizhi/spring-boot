package org.sangaizhi.springboot.dao;

import org.sangaizhi.springboot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author sangaizhi
 * @date 2017/6/29
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByName(String name);
}

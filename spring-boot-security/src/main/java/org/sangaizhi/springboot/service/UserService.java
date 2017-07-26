package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.User;

/**
 * @author sangaizhi
 * @date 2017/7/12
 */
public interface UserService {
    User findByUsername(String username);
}

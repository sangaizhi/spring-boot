package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.UserDao;
import org.sangaizhi.springboot.model.User;
import org.sangaizhi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sangaizhi
 * @date 2017/7/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

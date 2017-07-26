package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.UserRoleDao;
import org.sangaizhi.springboot.model.UserRole;
import org.sangaizhi.springboot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/7/14
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public List<UserRole> getByUserId(Long userId) {
        return userRoleDao.getByUserId(userId);
    }
}

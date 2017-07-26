package org.sangaizhi.springboot.dao;

import org.sangaizhi.springboot.model.User;
import org.sangaizhi.springboot.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by sangaizhi on 2017/7/14.
 */
@Repository
public interface UserRoleDao {
    List<UserRole> getByUserId(Long userId);
}

package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.UserRole;

import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/7/14
 */
public interface UserRoleService {
    List<UserRole> getByUserId(Long userId);
}

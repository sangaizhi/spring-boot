package org.sangaizhi.springboot.jpa.dao;


import org.sangaizhi.springboot.jpa.mdoel.User;
import org.sangaizhi.springboot.jpa.repository.CustomRepository;

/**
 * @author sangaizhi
 * @date 2017/6/19
 */
public interface CustomUserDao extends CustomRepository<User,Long> {
}

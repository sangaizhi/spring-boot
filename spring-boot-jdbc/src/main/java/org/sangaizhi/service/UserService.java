package org.sangaizhi.service;

import org.sangaizhi.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

/**
 * created by sangaizhi on 2017/6/16.
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param user
     */
    void save(User user);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 name 删除
     * @param name
     */
    void deleteByName(String name);

    /**
     * 查询所有 user
     * @return
     */
    List queryList();

    /**
     * 删除所有
     */
    void deleteAll();

}

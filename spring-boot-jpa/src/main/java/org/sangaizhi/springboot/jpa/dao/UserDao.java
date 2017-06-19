package org.sangaizhi.springboot.jpa.dao;

import java.util.List;

import org.sangaizhi.springboot.jpa.mdoel.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sangaizhi
 * @date 2017/6/16
 */
public interface UserDao extends JpaRepository<User, Long>{

    /**
     * 相当于 select u from User u where u.name=?
     * 也可以是 findName、readByName、readName、queryName、queryByName、getName、getByName
     * @return
     */
    List<User> findByName(String name);

    List<User> getByName(String name);

    List<User> readByName(String name);

    /**
     * 相当于 select u from User u where u.name like ?
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);

    /**
     * 相当于 select u from User u where u.name=? and u.address=?
     * @param name
     * @param address
     * @return
     */
    List<User> findByNameAndAddress(String name, String address);

    /**
     * 限制结果集的数量
     * 相当于 select u from User u where u.name=? limit 0,10
     * @param name
     * @return
     */
    List<User> findFirst10ByName(String name);

    /**
     * 限制结果集的数量
     * 相当于 select u from User u where u.name=? limit 0,30
     * @param name
     * @return
     */
    List<User> findTop30ByAddressLike(String name);

    /**
     * 使用 NamedQuery 里定义的查询语句
     * @param name
     * @return
     */
    List<User> findByNameWithNamedQuery(String name);


    /**
     * 使用 @Query 查询的参数索引,
     * @param address
     * @return
     */
    @Query("select u from User u where u.address = ?")
    List<User> findByAddressWithArgIndex(String address);


    /**
     * 使用 @Query 查询的命名参数
     * @param address
     * @return
     */
    @Query("select  u from User u where u.address=:address")
    List<User> findByAddressWithArgsName(@Param("address") String address);


    /**
     * 更新查询
     * 采用 @Modifying 和 @Query 注解组合更新查询
     * @param newName
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User u set u.name = ?1 where u.name = ?2")
    int updateName(String newName, String oldName);

    /**
     * 分页查询
     * @param name
     * @return
     */
    Page<User> findByName(String name, Pageable pageable);

    /**
     * 排序查询
     * @param name
     * @param sort
     * @return
     */
    List<User> findByName(String name, Sort sort);

}

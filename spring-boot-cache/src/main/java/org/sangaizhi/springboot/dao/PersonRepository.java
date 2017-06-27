package org.sangaizhi.springboot.dao;

import org.sangaizhi.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sangaizhi
 * @date 2017/6/23
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}


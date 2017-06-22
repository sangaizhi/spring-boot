package org.sangaizhi.springboot.dao;

import org.sangaizhi.springboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by sangaizhi on 2017/6/22.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}

package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.Person;

/**
 * created by sangaizhi on 2017/6/22.
 */
public interface PersonService {
    Person save(Person person);
    void remove(Long id);
    Person findOne(Person person);
}

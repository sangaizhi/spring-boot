package org.sangaizhi.springboot.service;

import org.sangaizhi.springboot.model.Person;

/**
 * created by sangaizhi on 2017/6/22.
 */
public interface PersonService {
    Person saveWithRollBack(Person person);
    Person saveWithoutRollBack(Person person);
}

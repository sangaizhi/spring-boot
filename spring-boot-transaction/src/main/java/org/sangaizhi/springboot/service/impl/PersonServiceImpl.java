package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.PersonRepository;
import org.sangaizhi.springboot.model.Person;
import org.sangaizhi.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sangaizhi
 * @date 2017/6/22
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 指定事务回滚的异常
     * @param person
     * @return
     */
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person saveWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if("sangaizhi".equals(person.getName())){
            throw new IllegalArgumentException("sangaizhi  已经存在，数据会回滚");
        }
        return p;
    }

    /**
     * 指定事务不回滚的异常
     * @param person
     * @return
     */
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person saveWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if("sangaizhi".equals(person.getName())){
            throw new IllegalArgumentException("sangaizhi  已经存在，数据不会回滚");
        }
        return p;
    }
}

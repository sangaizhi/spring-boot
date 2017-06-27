package org.sangaizhi.springboot.service.impl;

import org.sangaizhi.springboot.dao.PersonRepository;
import org.sangaizhi.springboot.model.Person;
import org.sangaizhi.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
     * 更新或者新增缓存中的数据
     * @param person
     * @return
     */
    @Override
    @CachePut(value = "people", key="#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为ID、key是:"+p.getId() + "数据做了缓存");
        return p;
    }

    /**
     * 从 people中删除key为id的数据
     * @param id
     */
    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("删除了ID、key是:"+id+"的数据缓存");
        personRepository.delete(id);
    }

    /**
     * 缓存 key为person的id 的数据到缓存 people中
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "people",key="#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为ID、key是:"+p.getId() + "数据做了缓存");
        return p;
    }
}

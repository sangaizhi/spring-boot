package org.sangaizhi.springboot.jpa.repository.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.sangaizhi.springboot.jpa.repository.CustomRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * @author sangaizhi
 * @date 2017/6/19
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements CustomRepository<T, ID> {

    private final EntityManager entityManager;
    public CustomRepositoryImpl(Class<T> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }
}

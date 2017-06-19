package org.sangaizhi.springboot.jpa.repository.factory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.sangaizhi.springboot.jpa.repository.impl.CustomRepositoryImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * @author sangaizhi
 * @date 2017/6/19
 */
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class CustomRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean {

    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager){
        return new CustomRepositoryFactory(entityManager);
    }

    private static class CustomRepositoryFactory extends JpaRepositoryFactory {

        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }

        /**
         * 获得当前自定义的 Repository 实现
         * @param information
         * @param entityManager
         * @param <T>
         * @param <ID>
         * @return
         */
        protected <T, ID extends Serializable>SimpleJpaRepository<?,?> getTargetRepository( RepositoryInformation information, EntityManager entityManager){
            return new CustomRepositoryImpl<T, ID>((Class<T>)information.getDomainType(), entityManager);
        }

        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){
            return CustomRepositoryImpl.class;
        }
    }

    public CustomRepositoryFactoryBean(Class repositoryInterface) {
        super(repositoryInterface);
    }
}

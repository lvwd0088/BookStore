package com.lyg.bookstore.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class BaseRepositoryImpl<T, TD extends Serializable> extends SimpleJpaRepository<T, TD>
    implements BaseRepository<T, TD>{

    private final EntityManager entityManager;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager){
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean isExist(TD td) {
        return false;
    }

    @Override
    public boolean isNotExist(TD td) {
        return false;
    }
}

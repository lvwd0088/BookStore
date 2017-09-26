package com.lyg.bookstore.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

public class BaseRepositoryImpl<T, TD extends Serializable> extends SimpleJpaRepository<T, TD>
        implements BaseRepository<T, TD> {

    private final EntityManager entityManager;
    private final Class<T> domainClass;
    private final String domainName;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
        this.domainClass = domainClass;
        this.domainName = domainClass.getName();
    }

    @Override
    public boolean isExist(TD td) {
        Optional<T> tOptional = Optional.ofNullable(entityManager.find(domainClass, td));
        return tOptional.isPresent();
    }

    @Override
    public boolean isNotExist(TD td) {
        return !isExist(td);
    }
}

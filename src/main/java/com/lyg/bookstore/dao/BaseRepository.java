package com.lyg.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, TD extends Serializable> extends JpaRepository<T, TD>{

    /**
     * 根据主键ID验证实体是否存在
     * @param td
     * @return
     */
    boolean isExist(TD td);

    /**
     * 根据主键ID验证实体是否不存在
     * @param td
     * @return
     */
    boolean isNotExist(TD td);

}

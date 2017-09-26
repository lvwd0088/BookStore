package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.dao.BaseRepository;
import com.lyg.bookstore.model.basic.BookType;

import java.util.List;

public interface BookTypeRepository extends BaseRepository<BookType,Long> {

    List<BookType> findAllByOrderByAddTimeAsc();

    Integer countByName(String name);

    Integer countByNameAndIdIsNot(String name, Long id);

}

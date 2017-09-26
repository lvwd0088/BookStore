package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.dao.BaseRepository;
import com.lyg.bookstore.model.basic.Book;

public interface BookRepository extends BaseRepository<Book, Long> {

    Integer countByNameAndIdNot(String name, Long id);

}

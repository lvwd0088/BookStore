package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.model.basic.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

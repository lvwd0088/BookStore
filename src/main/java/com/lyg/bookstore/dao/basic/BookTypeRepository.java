package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.model.basic.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTypeRepository extends JpaRepository<BookType,Long>{

    List<BookType> findAllByOrderByAddTimeAsc();

    Integer countByName(String name);

    Integer countByNameAndIdIsNot(String name, Long id);

}

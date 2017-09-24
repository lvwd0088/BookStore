package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.model.basic.BookLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by weida on 2017/7/18.
 * 书签相关jpa dao
 */
public interface BookLabelRepository extends JpaRepository<BookLabel,Long>{

    List<BookLabel> findAllByOrderByAddTimeAsc();

    Integer countByName(String name);

}

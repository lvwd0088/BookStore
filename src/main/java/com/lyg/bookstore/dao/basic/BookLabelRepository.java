package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.dao.BaseRepository;
import com.lyg.bookstore.model.basic.BookLabel;

import java.util.List;

/**
 * Created by weida on 2017/7/18.
 * 书签相关jpa dao
 */
public interface BookLabelRepository extends BaseRepository<BookLabel,Long> {

    List<BookLabel> findAllByOrderByAddTimeAsc();

    Integer countByName(String name);

    Integer countByIdIn(List<Long> ids);

}

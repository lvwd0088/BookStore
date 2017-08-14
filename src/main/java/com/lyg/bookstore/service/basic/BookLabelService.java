package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.model.basic.BookLabel;

import java.util.List;

/**
 * Created by weida on 2017/7/18.
 */
public interface BookLabelService {

//    List<BookLabel> findAllByOrderByIdAsc();

    List<BookLabel> query();

    void save(String labelName) throws MyException;

    void delete(Long id);

}

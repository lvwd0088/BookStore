package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.model.basic.Label;

import java.util.List;

/**
 * Created by weida on 2017/7/18.
 */
public interface LabelService {

//    List<Label> findAllByOrderByIdAsc();

    List<Label> query();

    void save(String labelName) throws MyException;

    void delete(Long id);

}

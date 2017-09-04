package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.VO.basic.BookTypeVo;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.model.basic.BookType;

import java.util.List;


public interface BookTypeService {

    List<BookTypeVo> listBookType();

    void saveBookType(BookType bookType) throws MyException;

    void updateBookType(BookType bookTypeForm) throws MyException;

    void deleteBookType(Long id);

}

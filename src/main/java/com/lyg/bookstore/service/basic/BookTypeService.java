package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.vo.basic.BookTypeVo;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.model.basic.BookType;

import java.util.List;


public interface BookTypeService {

    List<BookTypeVo> listBookType();

    void saveBookType(BookTypeVo bookTypeVo) throws MyException;

    void updateBookType(BookType bookTypeForm) throws MyException;

    void deleteBookType(Long id);

}

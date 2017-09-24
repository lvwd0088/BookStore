package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.common.PaginationHelper;
import com.lyg.bookstore.dao.basic.BookRepository;
import com.lyg.bookstore.service.basic.BookService;
import com.lyg.bookstore.vo.basic.BookVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Resource
    private BookRepository bookRepository;

    public PaginationHelper list(){
        return null;
    }

    public void save(BookVo bookVo){

    }

    public void update(BookVo bookVo){

    }

    public void delete(Long id){

    }


}

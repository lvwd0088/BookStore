package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.dao.basic.BookLabelDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by weida on 2017/7/18.
 */
@Service
@Transactional
public class BookLabelServiceImpl {

    @Resource
    private BookLabelDao bookLabelDao;

}

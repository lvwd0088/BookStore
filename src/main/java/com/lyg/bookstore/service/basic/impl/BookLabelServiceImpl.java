package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.BookLabelDao;
import com.lyg.bookstore.model.basic.BookLabel;
import com.lyg.bookstore.service.basic.BookLabelService;
import com.lyg.bookstore.utils.ConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by weida on 2017/7/18.
 */
@Service
@Transactional
public class BookLabelServiceImpl implements BookLabelService{

    @Resource
    private BookLabelDao bookLabelDao;

    @Override
    public List<BookLabel> query() {
        return bookLabelDao.findAllByOrderByAddTimeAsc();
    }

    @Override
    public void save(String labelName) throws MyException{
        Optional<Integer> count=Optional.ofNullable(bookLabelDao.countByName(labelName));
        if(ConvertUtils.parseIntegerToInt(count)>0){
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        BookLabel bookLabel=new BookLabel();
        bookLabel.setAddTime(new Date());
        bookLabel.setName(labelName);
        bookLabelDao.save(bookLabel);
    }

    @Override
    public void delete(Long id) {
        bookLabelDao.delete(id);
    }
}

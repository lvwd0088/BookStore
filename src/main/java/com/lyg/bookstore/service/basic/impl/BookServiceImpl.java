package com.lyg.bookstore.service.basic.impl;

import com.google.common.base.Preconditions;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.PaginationHelper;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.BookLabelRepository;
import com.lyg.bookstore.dao.basic.BookRepository;
import com.lyg.bookstore.dao.basic.BookTypeRepository;
import com.lyg.bookstore.model.basic.Book;
import com.lyg.bookstore.service.basic.BookService;
import com.lyg.bookstore.vo.basic.BookVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookTypeRepository bookTypeRepository;

    @Resource
    private BookLabelRepository bookLabelRepository;

    public PaginationHelper list() {
        return null;
    }

    public void save(BookVo bookVo) throws MyException {
        List<Long> labelIds = bookVo.getLabelIds();
        if (bookRepository.isExist(bookVo.getId())) {
            return;
//            throw
        }
        checkParams(bookVo);
        Book book = new Book();
        BeanUtils.copyProperties(bookVo, book, new String[]{"id"});
        bookRepository.save(book);
    }

    public void update(BookVo bookVo) throws MyException {
        if (bookRepository.countByNameAndIdNot(bookVo.getName(), bookVo.getId()) > 0) {
            return;
        }
        List<Long> labelIds = bookVo.getLabelIds();
        Optional<Book> bookOptional = Optional.ofNullable(bookRepository.findOne(bookVo.getId()));
        bookOptional.orElseThrow(() -> new MyException(CodeConstant.DATA_EXIST));
        checkParams(bookVo);
        bookOptional.ifPresent(book -> {
            BeanUtils.copyProperties(bookVo, book, new String[]{"id"});
            book.setUpdateTime(new Date());
            bookRepository.save(book);
        });
    }

    public void updateStatus(Long id, Integer status) throws MyException {
        Optional<Book> bookOptional = Optional.ofNullable(bookRepository.findOne(id));
        bookOptional.orElseThrow(() -> new MyException(CodeConstant.DATA_EXIST));
        bookOptional.ifPresent(book -> {
            book.setStatus(status);
            book.setUpdateTime(new Date());
            bookRepository.save(book);
        });
    }

    private void checkParams(BookVo bookVo) throws MyException {
        if (bookVo.getId() != null
                && bookRepository.countByNameAndIdNot(bookVo.getName(), bookVo.getId()) > 0) {
            return;
        }
        Preconditions.checkNotNull(bookVo.getTypeId());
        if (bookTypeRepository.isExist(bookVo.getTypeId())) {
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        //若设置了标签且标签数量不大于5个，则需验证标签是否都存在
        if (CollectionUtils.isNotEmpty(bookVo.getLabelIds())
                && bookVo.getLabelIds().size() <= 5
                && bookVo.getLabelIds().size() != bookLabelRepository.countByIdIn(bookVo.getLabelIds())) {
            throw new MyException(CodeConstant.DATA_EXIST);
        }
    }


}

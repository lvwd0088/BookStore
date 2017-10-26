package com.lyg.bookstore.service.basic.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.PaginationHelper;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.LabelRepository;
import com.lyg.bookstore.dao.basic.BookRepository;
import com.lyg.bookstore.dao.basic.BookTypeRepository;
import com.lyg.bookstore.mapper.BookLabelMapper;
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
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Resource
    private BookTypeRepository bookTypeRepository;

    @Resource
    private LabelRepository labelRepository;

    @Resource
    private BookLabelMapper bookLabelMapper;

    public PaginationHelper list() {
        return null;
    }

    public void save(BookVo bookVo) throws MyException {
        List<Long> labelIds = bookVo.getLabelIds();
        if (bookRepository.isExist(bookVo.getId())) {
            return;
        }
        checkParams(bookVo);
        Book book = new Book();
        BeanUtils.copyProperties(bookVo, book, new String[]{"id"});
        bookRepository.save(book);
        labelIds.stream().forEach(labelId -> bookLabelMapper.save(book.getId(), labelId));
    }

    public void update(BookVo bookVo) throws MyException {
        if (bookRepository.countByNameAndIdNot(bookVo.getName(), bookVo.getId()) > 0) {
            return;
        }
        List<Long> labelIds = bookVo.getLabelIds();
        Book book = Optional.ofNullable(bookRepository.findOne(bookVo.getId()))
                .orElseThrow(() -> new MyException(CodeConstant.DATA_EXIST));
        BeanUtils.copyProperties(bookVo, book, new String[]{"id"});
        book.setUpdateTime(new Date());
        bookRepository.save(book);
        checkBookLabels(labelIds, book.getId());
    }

    public void updateStatus(Long id, Integer status) throws MyException {
        Book book = Optional.ofNullable(bookRepository.findOne(id))
                .orElseThrow(() -> new MyException(CodeConstant.DATA_EXIST));
        book.setStatus(status);
        book.setUpdateTime(new Date());
        bookRepository.save(book);
    }

    public void delete(Long id) {
        bookRepository.delete(id);
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
        if (CollectionUtils.isEmpty(bookVo.getLabelIds())) {
            throw new MyException(CodeConstant.REQUEST_PARAM_ERROR);
        }
        //标签数量为1-5个
        if (bookVo.getLabelIds().size() > 5
                || bookVo.getLabelIds().size() != labelRepository.countByIdIn(bookVo.getLabelIds())) {
            throw new MyException(CodeConstant.DATA_EXIST);
        }
    }

    /**
     * 验证传入的书签列表是否与数据中的一致，若不一致则以最终传入的书签列表为准
     *
     * @param labelIds
     * @param bookId
     */
    private void checkBookLabels(List<Long> labelIds, Long bookId) {
        List<Long> dbLabelIds = bookLabelMapper.findAllLabelIdByBookId(bookId);
        if (dbLabelIds.containsAll(labelIds) && labelIds.containsAll(dbLabelIds)) {
            //若新传入的所属标签ID是否与先前保存的一致则表示未修改过标签
            return;
        } else {
            labelIds.stream()
                    .filter(x -> !dbLabelIds.contains(x))
                    .forEach(x -> bookLabelMapper.save(bookId, x));
            dbLabelIds.stream()
                    .filter(x -> !labelIds.contains(x))
                    .forEach(x -> bookLabelMapper.deleteByBookIdAndLabelId(bookId, x));
        }
    }


}

package com.lyg.bookstore.service.basic.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.lyg.bookstore.model.basic.BookType;
import com.lyg.bookstore.vo.basic.BookTypeVo;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.BookTypeDao;
import com.lyg.bookstore.service.basic.BookTypeService;
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
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeDao bookTypeDao;

    @Override
    public List<BookTypeVo> listBookType() {
        List<BookTypeVo> data = Lists.newArrayList();
        List<BookType> bookTypes = bookTypeDao.findAllByOrderByAddTimeAsc();
        if (CollectionUtils.isNotEmpty(bookTypes)) {
            ListMultimap<Long, BookTypeVo> bookTypeMap = ArrayListMultimap.create();
            for (BookType bookType : bookTypes) {
                //若存在父级则存入父级ID对应的list,否则存入父级List
                if (bookType.getParentId() == null) {
                    BookTypeVo parentBookType = new BookTypeVo();
                    BeanUtils.copyProperties(bookType, parentBookType);
                    parentBookType.setParent(bookType.getParentId());
                    data.add(parentBookType);
                } else {
                    BookTypeVo childrenBookType = new BookTypeVo();
                    BeanUtils.copyProperties(bookType, childrenBookType);
                    childrenBookType.setParent(bookType.getParentId());
                    bookTypeMap.put(bookType.getParentId(), childrenBookType);
                }
            }
            for (BookTypeVo bookTypeVo : data) {
                Optional<List<BookTypeVo>> belongBookTypesOptional = Optional.ofNullable(bookTypeMap.get(bookTypeVo.getId()));
                belongBookTypesOptional.ifPresent(belongBookTypes -> {
                    bookTypeVo.setChildren(belongBookTypes);
                });
            }
        }
        return data;
    }

    @Override
    public void saveBookType(BookTypeVo bookTypeVo) throws MyException {
        Preconditions.checkNotNull(bookTypeVo.getName());
        BookType bookType = new BookType();
        BeanUtils.copyProperties(bookTypeVo, bookType, new String[]{"id"} );
        bookType.setAddTime(new Date());
        bookType.setParentId(bookTypeVo.getParent());
        checkPersistentBookType(bookType);
        bookTypeDao.save(bookType);
    }

    @Override
    public void updateBookType(BookType bookTypeForm) throws MyException {
        Preconditions.checkNotNull(bookTypeForm.getName());
        Preconditions.checkNotNull(bookTypeForm.getId());
        checkPersistentBookType(bookTypeForm);
        Optional<BookType> bookTypeOptional = Optional.ofNullable(bookTypeDao.findOne(bookTypeForm.getId()));
        bookTypeOptional.orElseThrow(() -> new MyException(CodeConstant.DATA_NOT_EXIST));
        BookType bookTypeBean = bookTypeOptional.get();
        bookTypeBean.setName(bookTypeForm.getName());
        bookTypeBean.setDescription(bookTypeForm.getDescription());
        bookTypeDao.save(bookTypeBean);
    }

    @Override
    public void deleteBookType(Long id) {
        //TODO 需检查分类下是否存在对应的图书
        bookTypeDao.delete(id);
    }

    private void checkPersistentBookType(BookType bookType) throws MyException {
        //若存在父级ID,则需先验证父级ID是否存在
        if (bookType.getParentId() != null && bookTypeDao.getOne(bookType.getParentId()) == null) {
            throw new MyException(CodeConstant.DATA_NOT_EXIST);
        }
        //验证分类名称是否已经存在
        if (bookType.getId() != null) {
            if (bookTypeDao.countByNameAndIdIsNot(bookType.getName(), bookType.getId()) > 0) {
                throw new MyException(CodeConstant.DATA_EXIST);
            }
        } else if (bookTypeDao.countByName(bookType.getName()) > 0) {
            throw new MyException(CodeConstant.DATA_EXIST);
        }
    }

}

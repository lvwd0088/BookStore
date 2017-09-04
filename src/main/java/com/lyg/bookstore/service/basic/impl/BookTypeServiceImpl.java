package com.lyg.bookstore.service.basic.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.*;
import com.lyg.bookstore.VO.basic.BookTypeVo;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.BookTypeDao;
import com.lyg.bookstore.model.basic.BookType;
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
        List<BookTypeVo> data= Lists.newArrayList();
        List<BookType> bookTypes=bookTypeDao.findAllByOrderByAddTimeAsc();
        if(CollectionUtils.isNotEmpty(bookTypes)){
            ListMultimap<Long,BookType> bookTypeMap=ArrayListMultimap.create();
            for (BookType bookType : bookTypes) {
                //若存在父级则存入父级ID对应的list,否则存入父级List
                if (bookType.getParentId()==null){
                    BookTypeVo parentBookType=new BookTypeVo();
                    BeanUtils.copyProperties(bookType,parentBookType);
                    data.add(parentBookType);
                }else{
                    bookTypeMap.put(bookType.getParentId(),bookType);
                }
            }
            for (BookTypeVo bookTypeVo : data) {
                Optional<List<BookType>> belongBookTypesOptional=Optional.ofNullable(bookTypeMap.get(bookTypeVo.getId()));
                belongBookTypesOptional.ifPresent(belongBookTypes->{
                    bookTypeVo.setBelongBookTypes(belongBookTypes);
                });
            }
        }
        return data;
    }

    @Override
    public void saveBookType(BookType bookType) throws MyException {
        Preconditions.checkNotNull(bookType.getName());
        checkPersistentBookType(bookType);
        bookType.setAddTime(new Date());
        bookTypeDao.save(bookType);
    }

    @Override
    public void updateBookType(BookType bookTypeForm) throws MyException {
        Preconditions.checkNotNull(bookTypeForm.getName());
        Preconditions.checkNotNull(bookTypeForm.getId());
        checkPersistentBookType(bookTypeForm);
        Optional<BookType> bookTypeOptional= Optional.ofNullable(bookTypeDao.findOne(bookTypeForm.getId()));
        bookTypeOptional.orElseThrow(()-> new MyException(CodeConstant.DATA_NOT_EXIST));
        BookType bookTypeBean=bookTypeOptional.get();
        bookTypeBean.setName(bookTypeForm.getName());
        bookTypeDao.save(bookTypeBean);
    }

    @Override
    public void deleteBookType(Long id) {
        //TODO 需检查分类下是否存在对应的图书
        bookTypeDao.delete(id);
    }

    private void checkPersistentBookType(BookType bookType) throws MyException {
        //若存在父级ID,则需先验证父级ID是否存在
        if(bookType.getParentId()!=null&&bookTypeDao.getOne(bookType.getParentId())==null){
            throw new MyException(CodeConstant.DATA_NOT_EXIST);
        }
        //验证分类名称是否已经存在
        if(bookTypeDao.countByName(bookType.getName())>0){
            throw new MyException(CodeConstant.DATA_EXIST);
        }
    }

}

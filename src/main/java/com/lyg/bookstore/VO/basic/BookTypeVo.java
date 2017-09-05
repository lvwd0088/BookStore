package com.lyg.bookstore.VO.basic;

import com.google.common.collect.Lists;
import com.lyg.bookstore.model.basic.BookType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookTypeVo {

    private Long id;

    private String name;

    private String description;

    private Long parentId;

    private Date addTime;

    protected List<BookType> belongBookTypes= Lists.newArrayList();

}

package com.lyg.bookstore.vo.basic;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookTypeVo {

    private Long id;

    private String name;

    private String description;

    private Long parent;

    private Date addTime;

    protected List<BookTypeVo> children = Lists.newArrayList();

}

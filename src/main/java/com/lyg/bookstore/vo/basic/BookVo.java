package com.lyg.bookstore.vo.basic;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookVo {
    private Long id;

    private String name;

    private String authorName;

    private Long authorId;

    private Long typeId;

    private Integer status;

    private Long hits;

    private Date addTime;

    private Date updateTime;

    /**
     * 所属标签ID
     */
    private List<Long> labelIds = Lists.newArrayList();

}

package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="L_BOOKSTORE_BASIC_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "SEQ_BOOK_BASIC")
    @SequenceGenerator(name = "SEQ_BOOK_BASIC", sequenceName = "SEQ_BOOK_BASIC")
    private Long id;

    private String name;

    private String authorName;

    private Long authorId;

    private Long typeId;

    private Integer status;

    private Long hits;

    private Date addTime;

    private Date updateTime;

}

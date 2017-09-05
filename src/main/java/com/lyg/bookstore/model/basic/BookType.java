package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="L_BOOKSTORE_BOOK_TYPE")
public class BookType {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "SEQ_BOOK_TYPE")
    @SequenceGenerator(name = "SEQ_BOOK_TYPE", sequenceName = "SEQ_BOOK_TYPE")
    private Long id;

    private String name;

    private String description;

    private Long parentId;

    private Date addTime;

}

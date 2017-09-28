package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by weida on 2017/7/18.
 * 标签实体类
 */
@Data
@Entity
@Table(name="L_BOOKSTORE_BOOK_LABEL")
public class Label {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "SEQ_BOOK_LABEL")
    @SequenceGenerator(name = "SEQ_BOOK_LABEL", sequenceName = "SEQ_BOOK_LABEL")
    private Long id;

    private String name;

    private Date addTime;

}

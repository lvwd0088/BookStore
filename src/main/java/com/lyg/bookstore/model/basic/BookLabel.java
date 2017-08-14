package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by weida on 2017/7/18.
 * 标签实体类
 */
@Data
@Entity
@Table(name="L_BOOKSTORE_BASIC_USER")
public class BookLabel {
    @Id
    private Long id;

    private String name;

    private Date addTime;

}

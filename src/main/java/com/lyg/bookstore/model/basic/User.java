package com.lyg.bookstore.model.basic;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by weida on 2017/4/9.
 * 用户实体类
 */
@Entity
@Table(name="L_BOOKSTORE_BASIC_USER")
@Data
public class User implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_BOOK_USER")
    @SequenceGenerator(name = "SEQ_BOOK_USER", sequenceName = "SEQ_BOOK_USER")
    private Integer id;

    @Column(name = "nickName")
    private String nickName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "accountRemain")
    private Double accountRemain;

    @Column(name = "accountType")
    private Integer accountType;

    @Column(name = "registerTime")
    private Date registerTime;

    @Column(name = "lastLoginTime")
    private Date lastLoginTime;

}

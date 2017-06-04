package com.lyg.bookstore.model.basic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by weida on 2017/4/9.
 */
@Entity
@Table(name="L_BOOKSTORE_BASIC_USER")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Double getAccountRemain() {
        return accountRemain;
    }

    public void setAccountRemain(Double accountRemain) {
        this.accountRemain = accountRemain;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}

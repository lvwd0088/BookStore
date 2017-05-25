package com.lyg.bookstore.dao.basic;

import com.lyg.bookstore.model.basic.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by weida on 2017/4/9.
 */
public interface UserDao extends JpaRepository<User,Integer> {

}

package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.model.basic.User;

/**
 * Created by weida on 2017/6/4.
 */
public interface UserService {

    /**
     * 用户添加
     */
    void saveUser(User user) throws Exception;

    void updateUser(User userForm) throws Exception;

}

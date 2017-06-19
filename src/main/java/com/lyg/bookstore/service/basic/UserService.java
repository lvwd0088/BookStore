package com.lyg.bookstore.service.basic;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.PaginationHelper;
import com.lyg.bookstore.model.basic.User;

import java.util.Date;
import java.util.List;

/**
 * Created by weida on 2017/6/4.
 */
public interface UserService {

    PaginationHelper query(String condition,
                           Integer userType,
                           String beginTime,
                           String endTime,
                           Integer curPage,
                           Integer pageSize
    );

    /**
     * 用户添加
     */
    void saveUser(User user) throws Exception;

    void updateUser(User userForm) throws Exception;

    void deleteUser(Integer userId) throws Exception;

}

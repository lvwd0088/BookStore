package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.dao.basic.UserDao;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import com.lyg.bookstore.service.basic.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by weida on 2017/6/4.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) throws Exception {
        //验证邮箱、昵称、手机号是否已被使用
        if(userMapper.selectCountByNickNameOrMobileOrEmail(user.getNickName(),user.getMobile(),user.getEmail())>0){
//        if(userMapper.selectCountByNickNameOrMobileOrEmail(user)>0){
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        userDao.save(user);
    }
}

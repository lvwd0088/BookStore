package com.lyg.bookstore.service.basic.impl;

import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.PaginationHelper;
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
    public PaginationHelper query(String condition,
                                  Integer accountType,
                                  String beginTime,
                                  String endTime,
                                  Integer curPage,
                                  Integer pageSize) {
        PaginationHelper paginationHelper = new PaginationHelper(curPage, pageSize);
        paginationHelper.setTotal(userMapper.countByConditions(condition, accountType,beginTime, endTime));
        paginationHelper.setList(userMapper.selectByConditions(condition, accountType,beginTime, endTime, paginationHelper.getBeginIndex(), paginationHelper.getCurrent() * paginationHelper.getPageSize()));
        return paginationHelper;
    }

    @Override
    public void saveUser(User user) throws Exception {
        //验证邮箱、昵称、手机号是否已被使用
        if (userMapper.selectCountByNickNameOrMobileOrEmail(user.getNickName(), user.getMobile(), user.getEmail()) > 0) {
//        if(userMapper.selectCountByNickNameOrMobileOrEmail(user)>0){
            throw new MyException(CodeConstant.DATA_EXIST);
        }
        userDao.save(user);
    }

    @Override
    public void updateUser(User userForm) throws Exception {
        User user = userDao.findOne(userForm.getId());
        if (user == null) {
            throw new MyException(CodeConstant.DATA_NOT_EXIST);
        }

        if (userForm.getAccountType() != null) {
            user.setAccountType(userForm.getAccountType());
        }

        if (userForm.getAccountRemain() != null) {
            user.setAccountRemain(userForm.getAccountRemain());
        }

        //应该不必手动保存，user扔处于托管状态
        userDao.save(user);

    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
        userDao.delete(userId);
    }
}

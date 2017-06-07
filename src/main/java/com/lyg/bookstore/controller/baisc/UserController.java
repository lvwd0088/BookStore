package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.JsonMessage;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import com.lyg.bookstore.service.basic.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weida on 2017/4/9.
 */
@RestController
public class UserController{

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Map<String,Object> query(
            String condition,
            String beginTime,
            String endTime,
            Integer curPage,
            Integer pageSize
    ){
        if(curPage==null){
            curPage=1;
        }
        if(pageSize==null){
            pageSize=10;
        }
        try{
            return JsonMessage.success(userService.query(condition,beginTime,endTime,curPage,pageSize));
        }catch (Exception e){
//            e.printStackTrace();
        }
        return JsonMessage.success();
    }

    @RequestMapping(value = "/users/",method = RequestMethod.POST)
    public Map<String,Object> save(User user){
        try{
            userService.saveUser(user);
            return JsonMessage.success();
        }catch (Exception e){
//            return JsonMessage.failure(e,"用户保存失败");
        }
        return null;
    }

    @RequestMapping(value = "/users",method = RequestMethod.DELETE)
    public Map<String,Object> delete(@RequestParam(name = "userId") Integer userId){
        if(userId==null){
//            return JsonMessage.failure(new MyException(CodeConstant.REQUEST_PARAM_ERROR));
        }
        try{
            userService.deleteUser(userId);
            return JsonMessage.success();
        }catch (Exception e){
//            return JsonMessage.failure(e,"用户删除失败");
        }
        return null;
    }



}

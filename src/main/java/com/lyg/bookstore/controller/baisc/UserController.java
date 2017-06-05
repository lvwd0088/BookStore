package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.JsonMessage;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import com.lyg.bookstore.service.basic.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Object query(){
        try{
//            System.out.println(userMapper.getAll().get(0).getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonMessage.success();
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public Map<String,Object> save(User user){
        try{
            userService.saveUser(user);
            return JsonMessage.success();
        }catch (Exception e){
            return JsonMessage.failure(e,"用户保存失败");
        }
    }

    @RequestMapping(value = "/users",method = RequestMethod.PATCH)
    public Map<String,Object> update(User user){
        try{
            userService.saveUser(user);
            return JsonMessage.success();
        }catch (Exception e){
            return JsonMessage.failure(e,"用户保存失败");
        }
    }



}

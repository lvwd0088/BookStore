package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.dao.basic.UserDao;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weida on 2017/4/9.
 */
@RestController
public class UserController{
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "load")
    public Map<String,Object> load(ModelMap model){
        Map<String,Object> data=new HashMap<>();
        data.put("length",userDao.findAll().size());
        return data;
    }

}

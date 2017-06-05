package com.lyg.bookstore;

import com.lyg.bookstore.dao.basic.UserDao;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;

	@Test
	public void queryTest() {
        System.out.println(userMapper.selectByConditions(null,null,null).size());
    }

    @Test
    public void queryTestWithMobile(){
        System.out.println(userMapper.selectByConditions("008874564644",null,null));
//        System.out.println(userMapper.selectByCondition("%"+"0088"+"%").size());
    }

}

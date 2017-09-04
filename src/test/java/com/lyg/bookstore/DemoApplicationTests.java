package com.lyg.bookstore;

import com.lyg.bookstore.dao.basic.UserDao;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;

	@Test
	public void queryTest() {
        Optional<List<User>> users= Optional.ofNullable(userMapper.selectByConditions(null,null,null,null,0,10));
        users.ifPresent(user -> {
            System.out.println(user.size());
        });
        users= Optional.ofNullable(userMapper.selectByConditions(null,null,null,null,10,20));
        users.ifPresent(user -> {
            System.out.println(user.size());
        });
    }

    @Test
    public void queryTestWithMobile(){
//        System.out.println(userMapper.selectByConditions("008874564644",null,null));
//        System.out.println(userMapper.selectByCondition("%"+"0088"+"%").size());
    }

    @Test
    public void testTime(){
        System.out.println(LocalDateTime.now());
    }

}

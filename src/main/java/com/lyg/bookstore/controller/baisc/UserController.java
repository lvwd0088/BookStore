package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.JsonMessage;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import com.lyg.bookstore.service.basic.UserService;
import com.lyg.bookstore.utils.ValidatorUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by weida on 2017/4/9.
 */
@RestController
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping(value = "/users")
    public Map<String, Object> query(
            String condition,
            String beginTime,
            String endTime,
            Integer current,
            Integer accountType,
            Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        if((!StringUtils.isEmpty(beginTime)&&!ValidatorUtils.isDate(beginTime))
                ||(!StringUtils.isEmpty(endTime)&&!ValidatorUtils.isDate(endTime))){
            return JsonMessage.failure(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try {
            return JsonMessage.success(userService.query(condition, accountType, beginTime, endTime, current, pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessage.failure(e, "用户列表获取失败");
        }
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public Map<String, Object> save(User user) {
        try {
            userService.saveUser(user);
            return JsonMessage.success();
        } catch (Exception e) {
            return JsonMessage.failure(e, "用户保存失败");
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@RequestParam(name = "userId") Integer userId) {
        if (userId == null) {
            return JsonMessage.failure(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try {
            userService.deleteUser(userId);
            return JsonMessage.success();
        } catch (Exception e) {
            return JsonMessage.failure(e, "用户删除失败");
        }
    }


}

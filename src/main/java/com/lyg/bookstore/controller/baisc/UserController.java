package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.BookMessage;
import com.lyg.bookstore.common.JsonMessage;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.mapper.UserMapper;
import com.lyg.bookstore.model.basic.User;
import com.lyg.bookstore.service.basic.UserService;
import com.lyg.bookstore.utils.ValidatorUtils;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public BookMessage query(
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
            return JsonMessage.failure(e, "用户列表获取失败");
        }
    }

    @PatchMapping(value = "/users")
    public BookMessage update(@RequestBody User user) {
        if(user.getId()==null){
            return JsonMessage.failure(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try {
            userService.updateUser(user);
            return JsonMessage.success();
        } catch (Exception e) {
            return JsonMessage.failure(e, "用户信息修改失败");
        }
    }

    @PostMapping(value = "/users")
    public BookMessage save(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return JsonMessage.success();
        } catch (Exception e) {
            return JsonMessage.failure(e, "用户保存失败");
        }
    }

    @DeleteMapping(value = "/users")
    public BookMessage delete(@RequestParam(name = "userId") Integer userId) {
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

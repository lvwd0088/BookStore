package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.BookMessage;
import com.lyg.bookstore.common.JsonMessage;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.model.basic.BookType;
import com.lyg.bookstore.service.basic.BookTypeService;
import com.lyg.bookstore.utils.ValidatorUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class BookTypeController {

    @Resource
    private BookTypeService bookTypeService;

    @GetMapping(value = "/bookType")
    public BookMessage listBookType() {
        return JsonMessage.success(bookTypeService.listBookType());
    }

    @PostMapping(value = "/bookType")
    public BookMessage saveBookType(@RequestBody BookType bookType) {
        if (!ValidatorUtils.isNotEmptyAndLessThan(bookType.getName(), 50)
                || !ValidatorUtils.isNotEmptyAndLessThan(bookType.getDescription(), 200)) {
            return JsonMessage.failure(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try {
            bookTypeService.saveBookType(bookType);
            return JsonMessage.success();
        } catch (MyException e) {
            return new BookMessage(Integer.valueOf(e.getMessage()));
        }
    }

    @PatchMapping(value = "/bookType")
    public BookMessage updateBookType(@RequestBody BookType bookType) {
        if (bookType.getId() == null
                || StringUtils.isEmpty(bookType.getName())
                || !ValidatorUtils.isLessThan(bookType.getName(),50)
                || StringUtils.isEmpty(bookType.getDescription())
                || !ValidatorUtils.isLessThan(bookType.getDescription(),200)) {
            return JsonMessage.failure(CodeConstant.REQUEST_PARAM_ERROR);
        }

        try {
            bookTypeService.updateBookType(bookType);
            return JsonMessage.success();
        } catch (MyException e) {
            return new BookMessage(Integer.valueOf(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/bookType/{id}")
    public BookMessage deleteBookType(@PathVariable Long id) {
        bookTypeService.deleteBookType(id);
        return JsonMessage.success();
    }

}

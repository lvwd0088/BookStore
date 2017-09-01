package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.BookMessage;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.model.basic.BookLabel;
import com.lyg.bookstore.service.basic.BookLabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by weida on 2017/8/14.
 */
@RestController
@CrossOrigin
public class BookLabelController {

    @Resource
    private BookLabelService bookLabelService;

    @GetMapping(value = "/bookLabel")
    public BookMessage query(){
        return new BookMessage(CodeConstant.SUCCESS,bookLabelService.query());
    }

    @PostMapping(value = "/bookLabel")
    public BookMessage save(@RequestBody BookLabel bookLabel){
        if(StringUtils.isEmpty(bookLabel.getName())){
            return new BookMessage(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try{
            bookLabelService.save(bookLabel.getName());
            return new BookMessage(CodeConstant.SUCCESS);
        }catch (MyException e){
            return new BookMessage(Integer.valueOf(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/bookLabel/id")
    public BookMessage delete(@PathVariable("id")Long id){
        bookLabelService.delete(id);
        return new BookMessage(CodeConstant.SUCCESS);
    }

}

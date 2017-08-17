package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.BookMessage;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.service.basic.BookLabelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by weida on 2017/8/14.
 */
@RestController
public class BookLabelController {

    @Resource
    private BookLabelService bookLabelService;

    @RequestMapping(value = "/bookLabel",method = RequestMethod.GET)
    public BookMessage query(){
        return new BookMessage(CodeConstant.SUCCESS,bookLabelService.query());
    }

    @RequestMapping(value = "/bookLabel",method = RequestMethod.POST)
    public BookMessage save(@RequestParam(name = "name")String name){
        try{
            bookLabelService.save(name);
            return new BookMessage(CodeConstant.SUCCESS);
        }catch (MyException e){
            return new BookMessage(Integer.valueOf(e.getMessage()));
        }
    }

    @RequestMapping(value = "/bookLabel",method = RequestMethod.DELETE)
    public BookMessage delete(@RequestParam(name = "id")Long id){
        bookLabelService.delete(id);
        return new BookMessage(CodeConstant.SUCCESS);
    }

}

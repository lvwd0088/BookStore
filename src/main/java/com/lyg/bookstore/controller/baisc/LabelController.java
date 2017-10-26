package com.lyg.bookstore.controller.baisc;

import com.lyg.bookstore.common.BookMessage;
import com.lyg.bookstore.common.MyException;
import com.lyg.bookstore.common.constant.CodeConstant;
import com.lyg.bookstore.model.basic.Label;
import com.lyg.bookstore.service.basic.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by weida on 2017/8/14.
 */
@RestController
@CrossOrigin
public class LabelController {

    @Resource
    private LabelService labelService;

    @GetMapping(value = "/Label")
    public BookMessage query(){
        return new BookMessage(CodeConstant.SUCCESS,labelService.query());
    }

    @PostMapping(value = "/Label")
    public BookMessage save(@RequestBody Label Label){
        if(StringUtils.isEmpty(Label.getName())){
            return new BookMessage(CodeConstant.REQUEST_PARAM_ERROR);
        }
        try{
            labelService.save(Label.getName());
            return new BookMessage(CodeConstant.SUCCESS);
        }catch (MyException e){
            return new BookMessage(Integer.valueOf(e.getMessage()));
        }
    }

    @DeleteMapping(value = "/Label/{id}")
    public BookMessage delete(@PathVariable("id")Long id){
        labelService.delete(id);
        return new BookMessage(CodeConstant.SUCCESS);
    }

}

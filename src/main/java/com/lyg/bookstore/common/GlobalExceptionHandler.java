package com.lyg.bookstore.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * Created by weida on 2017/6/7.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public BookMessage exceptionHandler(Exception e){
        if(e instanceof MyException){

        }else{
            logger.error("gg");
        }
        return JsonMessage.failure(0);
    }
}

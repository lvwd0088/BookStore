package com.lyg.bookstore.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by weida on 2017/6/20.
 */
public final class DateUtils {

    private DateUtils(){

    }

    /**
     * 将dateString转为localDate类型数据并返回，转换失败则返回null
     * @param dateString 格式为(yyyy-MM-dd)的字符串
     * @return
     */
    public static LocalDate parseStringToData(String dateString) {
        try{
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(dateString, dateFormatter);
            return LocalDate.parse(dateString, dateFormatter);
        }catch (DateTimeParseException e){
            return null;
        }
    }

}

package com.lyg.bookstore.utils;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by weida on 2017/6/20.
 */
public final class ValidatorUtils {

    private ValidatorUtils(){

    }

    /**
     * 验证传入的日期字符串格式
     * @param dateString 日期字符串 格式为(yyyy-MM-dd)
     * @return
     */
    public static boolean isDate(String dateString){
        LocalDate localDate=DateUtils.parseStringToData(dateString);
        return localDate!=null;
    }

}

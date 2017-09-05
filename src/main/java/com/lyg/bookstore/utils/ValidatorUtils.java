package com.lyg.bookstore.utils;

import com.google.common.base.Preconditions;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by weida on 2017/6/20.
 */
public final class ValidatorUtils {

    private ValidatorUtils() {

    }

    /**
     * 验证string长度是否小于等于maxLength
     * @param string
     * @param maxLength
     * @return
     */
    public static boolean isLessThan(String string,Integer maxLength){
        Preconditions.checkNotNull(string);
        return string.trim().length()<=maxLength;
    }

    /**
     * 验证string长度是否大于等于minLength
     * @param string
     * @param minLength
     * @return
     */
    public static boolean isMoreThan(String string,Integer minLength){
        Preconditions.checkNotNull(string);
        return string.trim().length()>=minLength;
    }

    /**
     * 验证string长度小于等于maxLength并大于等于minLength
     * @param string
     * @param minLength
     * @return
     */
    public static boolean isBetWeen(String string,Integer minLength,Integer maxLength){
        Preconditions.checkNotNull(string);
        string=string.trim();
        return string.length()>=minLength&&string.length()<=maxLength;
    }

    /**
     * 验证string是否不为空且长度小于等于maxLength并大于等于minLength
     * @param string
     * @param minLength
     * @param maxLength
     * @return
     */
    public static boolean isNotEmptyAndBetween(String string, Integer minLength, Integer maxLength) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        return isBetWeen(string,minLength,maxLength);
    }

    /**
     * 验证string是否为不为空且长度小于等于maxLength
     * @param string
     * @param maxLength
     * @return
     */
    public static boolean isNotEmptyAndLessThan(String string, Integer maxLength) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        return isLessThan(string,maxLength);
    }

    /**
     * 验证string是否为不为空且长度大于等于minLength
     * @param string
     * @param minLength
     * @return
     */
    public static boolean isNotEmptyAndMoreThan(String string, Integer minLength) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        return isMoreThan(string,minLength);
    }

    /**
     * 验证传入的日期字符串格式
     *
     * @param dateString 日期字符串 格式为(yyyy-MM-dd)
     * @return
     */
    public static boolean isDate(String dateString) {
        try {
            LocalDate.parse(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

package com.lyg.bookstore.utils;

import java.util.Optional;

/**
 * 类型转换工具类
 * Created by weida on 2017/8/14.
 */
public final class ConvertUtils {

    private ConvertUtils(){

    }

    public static int parseIntegerToInt(Optional<Integer> num){
        //TODO 是否有更"java8"的写法？
        return num.isPresent()?num.get().intValue():0;
    }

}

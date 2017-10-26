package com.lyg.bookstore.utils;

import java.util.Random;

/**
 * 随机值工具类
 * Created by weida on 2017/7/9.
 */
public final class RandomUtils {

    private static final String RANDOMSTRINGSEED ="abcdefghijklmnopqrstuvwxyz0123456789";

    private RandomUtils() {

    }

    /**
     * 返回指定
     * @param size
     * @return
     */
    public static String getRandomString(int size){
        char[] randomChars=new char[size];
        for (int i=0;i<size;i++){
            randomChars[i]= RANDOMSTRINGSEED.charAt(new Random().nextInt(size));
        }
        return new String(randomChars);
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.getRandomString(10));
    }

}

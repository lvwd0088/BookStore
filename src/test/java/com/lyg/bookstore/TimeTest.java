package com.lyg.bookstore;

import org.junit.Test;

import java.time.LocalDateTime;

public class TimeTest {
    @Test
    public void testTime(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(LocalDateTime.now());
        LocalDateTime localDateTime1=LocalDateTime.of(2017,9,2,11,11,11);
        System.out.println(localDateTime1);
        System.out.println(localDateTime.plusHours(3).plusDays(1));
    }
}

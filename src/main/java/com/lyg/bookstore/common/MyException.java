package com.lyg.bookstore.common;

/**
 * Created by weida on 2017/6/4.
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(int message) {
        super(String.valueOf(message));
    }

}

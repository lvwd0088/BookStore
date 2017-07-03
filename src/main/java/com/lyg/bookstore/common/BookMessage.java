package com.lyg.bookstore.common;

import java.io.Serializable;

/**
 * json通用返回类
 */
public class BookMessage implements Serializable{

    private static final long serialVersionUID = 4371405392523160716L;

    /**
     * 状态吗
     */
    private Integer code;

    /**
     * 错误信息提示
     */
    private String msg;

    /**
     * 返回的数据对象
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BookMessage(){

    }

    public BookMessage(Integer code) {
        this.code = code;
    }

    public BookMessage(Integer code, Object data) {
        this.data = data;
        this.code = code;
//        switch (code){
//            case Code
//        }
    }

    public BookMessage(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

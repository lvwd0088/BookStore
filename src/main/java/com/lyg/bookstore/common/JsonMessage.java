package com.lyg.bookstore.common;

import com.lyg.bookstore.common.constant.CodeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weida on 2017/6/4.
 * JSON数据包装类
 */
public class JsonMessage {

    private static final Logger logger=LoggerFactory.getLogger(JsonMessage.class);

    public static Map<String,Object> initJsonString(Integer code,Object data){
        Map<String,Object> respData=new HashMap<>();
        respData.put("code", code);
        respData.put("data", data);
        return respData;
    }

    /**
     * 返回状态码为操作成功的JSON数据(含返回数据)
     * @param data
     * @return
     */
    public static Map<String,Object> success(Object data){
        return initJsonString(CodeConstant.SUCCESS,data);
    }


    /**
     * 返回状态码为操作成功的JSON数据(不含返回数据)
     * @return
     */
    public static Map<String,Object> success(){
        return success(null);
    }

    /**
     * 返回状态码为操作失败的JSON数据
     * @param e
     * @param message
     * @return
     */
    public static Map<String,Object> failure(Exception e,String message){
        if(e instanceof MyException){
            Integer code=Integer.parseInt(e.getMessage());
            return failure(code);
        }else{
            logger.error(message);
            return failure(0);
        }
    }

    /**
     * 返回状态码为操作失败的JSON数据
     * @param code
     * @return
     */
    public static Map<String,Object> failure(Integer code){
        return initJsonString(code,null);
    }

}

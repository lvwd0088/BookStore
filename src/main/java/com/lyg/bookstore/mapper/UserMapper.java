package com.lyg.bookstore.mapper;

import com.lyg.bookstore.model.basic.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by weida on 2017/6/4.
 */
public interface UserMapper {

    @Select({
            "<script>",
            "SELECT count(*) FROM L_BOOKSTORE_BASIC_USER",
            "WHERE 1=1",
            "<when test='condition!=null'>",
            "AND (",
            "mobile like concat(concat('%',#{condition}),'%')",
            "or nickName like concat(concat('%',#{condition}),'%')",
            "or email like concat(concat('%',#{condition}),'%')",
            ")",
            "</when>",
            "<when test='accountType!=null and accountType!=0'>",
            "AND accountType = #{accountType}",
            "</when>",
            "<when test='beginTime!=null'>",
            "AND registerTime &gt;= to_date(#{beginTime},'YYYY-MM-DD')",
            "</when>",
            "<when test='endTime!=null'>",
            "AND registerTime &lt;= to_date(#{endTime},'YYYY-MM-DD')",
            "</when>",
            "</script>"
    })
    Integer countByConditions(
            @Param("condition") String condition,
            @Param("accountType") Integer accountType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime
    );

    @Select({
            "<script>",
            "SELECT * FROM (",
            "SELECT U.*,ROWNUM rn FROM ",
            "(SELECT * FROM L_BOOKSTORE_BASIC_USER",
            "WHERE 1=1",
            "<when test='condition!=null'>",
            "AND (",
            "mobile like concat(concat('%',#{condition}),'%')",
            "or nickName like concat(concat('%',#{condition}),'%')",
            "or email like concat(concat('%',#{condition}),'%')",
            ")",
            "</when>",
            "<when test='accountType!=null and accountType!=0'>",
            "AND accountType = #{accountType}",
            "</when>",
            "<when test='beginTime!=null'>",
            "AND registerTime &gt;= to_date(#{beginTime},'YYYY-MM-DD')",
            "</when>",
            "<when test='endTime!=null'>",
            "AND registerTime &lt;= to_date(#{endTime},'YYYY-MM-DD')",
            "</when>",
            "AND ROWNUM &lt;=#{endIndex}",
            "order by registerTime desc) u ",
            ") where RN &gt;#{beginIndex}",
            "</script>"
    })
    List<User> selectByConditions(
            @Param("condition") String condition,
            @Param("accountType") Integer accountType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("beginIndex") Integer beginIndex,
            @Param("endIndex") Integer endIndex
    );

    @Select("select count(*) from L_BOOKSTORE_BASIC_USER where nickName=#{nickName} or mobile=#{mobile} or email=#{email}")
    Integer selectCountByNickNameOrMobileOrEmail(
            @Param("nickName") String nickName,
            @Param("mobile") String mobile,
            @Param("email") String email
    );
//    Integer selectCountByNickNameOrMobileOrEmail(User user);

}

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
            "<when test='registerTimeStart!=null'>",
            "AND registerTime &gt;= concat(concat('%',#{registerTimeStart}),'%')",
            "</when>",
            "<when test='registerTimeEnd!=null'>",
            "AND registerTime &lt;= concat(concat('%',#{registerTimeEnd}),'%')",
            "</when>",
            "</script>"
    })
    Integer countByConditions(
            @Param("condition") String condition,
            @Param("registerTimeStart") String registerTimeStart,
            @Param("registerTimeEnd") String registerTimeEnd
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
            "<when test='registerTimeStart!=null'>",
            "AND registerTime &gt;= concat(concat('%',#{registerTimeStart}),'%')",
            "</when>",
            "<when test='registerTimeEnd!=null'>",
            "AND registerTime &lt;= concat(concat('%',#{registerTimeEnd}),'%')",
            "</when>",
            "AND ROWNUM &lt;=#{endIndex}",
            "order by registerTime desc) u ",
            ") where RN &gt;#{beginIndex}",
            "</script>"
    })
    List<User> selectByConditions(
            @Param("condition") String condition,
            @Param("registerTimeStart") String registerTimeStart,
            @Param("registerTimeEnd") String registerTimeEnd,
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

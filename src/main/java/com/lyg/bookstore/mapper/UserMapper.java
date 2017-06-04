package com.lyg.bookstore.mapper;

import com.lyg.bookstore.model.basic.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by weida on 2017/6/4.
 */
public interface UserMapper {

//    @Select("select * from L_BOOKSTORE_BASIC_USER")
    @Select({
        "<script>",
            "SELECT * FROM L_BOOKSTORE_BASIC_USER",
            "WHERE 1=1",
            "<when test='mobile!=null'>",
                "AND mobile like #{mobile}",
            "</when>",
        "</script>"
    })
    List<User> getAll(@Param("mobile") String mobile);

    @Select("select count(*) from L_BOOKSTORE_BASIC_USER where nickName=#{nickName} or mobile=#{mobile} or email=#{email}")
    Integer selectCountByNickNameOrMobileOrEmail(
            @Param("nickName") String nickName,
            @Param("mobile") String mobile,
            @Param("email") String email
    );
//    Integer selectCountByNickNameOrMobileOrEmail(User user);

}

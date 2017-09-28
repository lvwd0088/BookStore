package com.lyg.bookstore.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookLabelMapper {

    @Insert("insert into L_BOOKSTORE_BOOK_BOOKLABEL(bookId,labelId) values(#{bookId},#{labelId})")
    void save(@Param("bookId") Long bookId, @Param("labelId") Long labelId);

    @Update("update L_BOOKSTORE_BOOK_BOOKLABEL set labelId = #{labelId} where bookId = #{bookId}")
    void update(@Param("bookId") Long bookId, @Param("labelId") Long labelId);

    @Delete("delete from L_BOOKSTORE_BOOK_BOOKLABEL where bookId = #{bookId} and labelId = #{labelId}")
    List<Long> deleteByBookIdAndLabelId(@Param("bookId") Long bookId, @Param("labelId") Long labelId);

    @Select("select labelId from L_BOOKSTORE_BOOK_BOOKLABEL where bookId = #{bookId}")
    List<Long> findAllLabelIdByBookId(@Param("bookId") Long bookId);


}

package com.example.demo.mappers;

import com.example.demo.pojo.chapter_table;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/25
 */
@Mapper
public interface Mapper_chapter_table {
    @Select("select * from chapter_table")
    List<chapter_table> SELECTALL();

    @Select("select * from chapter_table where chapter_number=#{chapter_number}")
    chapter_table SELECT_BY_chapter_number(String chapter_number);

    @Insert("insert into chapter_table values (#{chapter_number},#{chapter_name})")
    void ADD(chapter_table chapter_table);

    @Delete("delete from chapter_table where chapter_number=#{chapter_number}")
    void DELETE_BY_chapter_number(String chapter_number);

    @Update("update chapter_table set chapter_name=#{chapter_name} where chapter_number=#{chapter_number}")
    void UPDATA(@Param("chapter_number") String chapter_number, @Param("chapter_name") String chapter_name);

    @Select("select MAX(chapter_number*1) from chapter_table")
    String MAX();
}

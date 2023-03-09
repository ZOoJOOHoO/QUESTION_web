package com.example.demo.mappers;

import com.example.demo.pojo.question_table;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/25
 */
@Mapper
public interface Mapper_question_table {
    @Select("select * from question_table order by chapter_number*1,question_number*1")//存在问题!!!
    List<question_table> SELECTALL();

    @Select("select * from question_table where question_number=#{question_number} and chapter_number=#{chapter_number}")
    question_table SELECT_BY_question_number_and_chapter_number(@Param("question_number") String question_number,@Param("chapter_number") String chapter_number);

    @Select("select * from question_table where chapter_number=#{chapter_number}")
    List<question_table> SELECT_BY_chapter_number(String chapter_number);

    @Insert("insert into question_table values(#{question_number},#{chapter_number},#{question_type},#{question_title},#{option_a},#{option_b},#{option_c},#{option_d},#{question_answer},#{question_explain},#{submit_number},#{wrong_number},#{accuracy},#{img_url})")
    void ADD_CHOOSE(question_table question_table);

    @Delete("delete from question_table where question_number=#{question_number} and chapter_number=#{chapter_number}")
    void DELETE_BY_question_number_and_chapter_number(@Param("question_number") String question_number,@Param("chapter_number") String chapter_number);

    @Delete("delete from question_table where question_number=#{question_number}")
    void DELETE_BY_question_number(String question_number);

    /*返回当前最大题目最大编号*/
    @Select("select MAX(question_number*1) from question_table")
    String MAX();

    @Update("update question_table set img_url=#{img_url} where question_number=#{question_number}")
    void add_imgurl(@Param("question_number") String question_number,@Param("img_url") String img_url);
}

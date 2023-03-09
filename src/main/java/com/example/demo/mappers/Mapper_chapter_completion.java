package com.example.demo.mappers;

import com.example.demo.pojo.chapter_completion;
import com.example.demo.pojo.chapter_completion_2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/25
 */
@Mapper
public interface Mapper_chapter_completion {
    @Select("select * from chapter_completion")
    List<chapter_completion> SELECTALL();

    List<chapter_completion_2> SELECT_END(@Param("chapter_number") String chapter_number, @Param("class_number") String class_number);
}

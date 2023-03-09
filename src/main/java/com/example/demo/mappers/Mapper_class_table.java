package com.example.demo.mappers;

import com.example.demo.pojo.class_table;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/25
 */
@Mapper
public interface Mapper_class_table {
    @Select("select * from class_table")
    List<class_table> SELECTALL();

    @Insert("insert into class_table values (#{class_number},#{class_name},#{teacher_number})")
    void ADD(class_table class_table);

    @Delete("delete from class_table where class_number=#{class_number}")
    void DELECT_BY_class_number(String class_number);

    @Select("select * from class_table where teacher_number=#{teacher_number}")
    List<class_table> SELECTALL_BY_teacher_number(String teacher_number);

    @Update("update class_table set class_name=#{class_name} where class_number=#{class_number}")
    void UPDATA(@Param("class_number") String class_number,@Param("class_name") String class_name);

    void DELETE_batch(@Param("class_numbers") String[] class_numbers);
}

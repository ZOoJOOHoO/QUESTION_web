package com.example.demo.mappers;

import com.example.demo.pojo.student_user;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/25
 */
@Mapper
public interface Mapper_student_user {
    @Select("select * from student_user")
    List<student_user> SELECTALL();

    @Insert("insert into student_user values (#{student_number},#{class_number},#{student_name},#{student_account},#{student_password},#{student_chapter})")
    void ADD(student_user student_user);

    @Delete("delete from student_user where student_number=#{student_number}  ")
    void Delete_BY_student_number(String student_number);

    @Select("select * from student_user where class_number=#{class_number}")
    List<student_user> SELECTALL_BY_class_number(String class_number);

    @Update("update student_user set student_name=#{student_name} where student_number=#{student_number}")
    void UPDATA(@Param("student_number") String student_number, @Param("student_name") String student_name);

    void DELETE_batch(@Param("stu_numbers") String[] stu_numbers);
}

package com.example.demo.mappers;

import com.example.demo.pojo.teacher_user;
import org.apache.ibatis.annotations.*;


import java.util.List;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
@Mapper
public interface Mapper_teacher_user {
    @Select("select * from teacher_user")
    List<teacher_user> SELECT_ALL();

    @Insert("insert into teacher_user values (#{teacher_number},#{teacher_name},#{teacher_account},#{teacher_password})")
    void ADD(teacher_user teacher_user);

    @Delete("delete from teacher_user where teacher_number=#{teacher_number}")
    void DELETE_by_teacher_number(String teacher_number);

    @Select("select * from teacher_user where teacher_account=#{teacher_account} and teacher_password=#{teacher_password}")
    teacher_user SELECT_login(@Param("teacher_account") String teacher_account, @Param("teacher_password") String teacher_password);

    @Select("select * from teacher_user where teacher_account=#{teacher_account}")
    teacher_user SELECT_BY_teacher_account(String teacher_account);
}

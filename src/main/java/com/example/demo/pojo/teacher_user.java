package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class teacher_user {
     private String teacher_number;
     private String teacher_name;
     private String teacher_account;
     private String teacher_password;

    @Override
    public String toString() {
        return "teacher_user{" +
                "teacher_number='" + teacher_number + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_account='" + teacher_account + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                '}';
    }

    public String getTeacher_number() {
        return teacher_number;
    }

    public void setTeacher_number(String teacher_number) {
        this.teacher_number = teacher_number;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_account() {
        return teacher_account;
    }

    public void setTeacher_account(String teacher_account) {
        this.teacher_account = teacher_account;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }
}

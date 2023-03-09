package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class student_user {
    private String  student_number;
    private String  class_number;
    private String  student_name;
    private String  student_account;
    private String  student_password;

    private String  student_chapter;

    public String getStudent_chapter() {
        return student_chapter;
    }

    public void setStudent_chapter(String student_chapter) {
        this.student_chapter = student_chapter;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_account() {
        return student_account;
    }

    public void setStudent_account(String student_account) {
        this.student_account = student_account;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    @Override
    public String toString() {
        return "student_user{" +
                "student_number='" + student_number + '\'' +
                ", class_number='" + class_number + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_account='" + student_account + '\'' +
                ", student_password='" + student_password + '\'' +
                ", student_chapter='" + student_chapter + '\'' +
                '}';
    }
}

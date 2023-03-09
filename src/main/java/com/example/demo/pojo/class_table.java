package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class class_table {
    private String class_number;
    private String class_name;
    private String teacher_number;

    @Override
    public String toString() {
        return "class_table{" +
                "class_number='" + class_number + '\'' +
                ", class_name='" + class_name + '\'' +
                ", teacher_number='" + teacher_number + '\'' +
                '}';
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTeacher_number() {
        return teacher_number;
    }

    public void setTeacher_number(String teacher_number) {
        this.teacher_number = teacher_number;
    }
}

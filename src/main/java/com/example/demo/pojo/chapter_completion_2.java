package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class chapter_completion_2 {
    private String chapter_number;
    private String student_number;
    private String answer_record;
    private String error_record;

    private String student_name;

    private String class_number;

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getAnswer_record() {
        return answer_record;
    }

    public void setAnswer_record(String answer_record) {
        this.answer_record = answer_record;
    }

    public String getError_record() {
        return error_record;
    }

    public void setError_record(String error_record) {
        this.error_record = error_record;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    @Override
    public String toString() {
        return "chapter_completion_2{" +
                "chapter_number='" + chapter_number + '\'' +
                ", student_number='" + student_number + '\'' +
                ", answer_record='" + answer_record + '\'' +
                ", error_record='" + error_record + '\'' +
                ", student_name='" + student_name + '\'' +
                ", class_number='" + class_number + '\'' +
                '}';
    }
}

package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class chapter_table {
    private String chapter_number;
    private String chapter_name;

    @Override
    public String toString() {
        return "chapter_table{" +
                "chapter_number='" + chapter_number + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                '}';
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
}

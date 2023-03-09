package com.example.demo.pojo;

/**
 * @author ZJH111
 * * @date 2022/11/24
 */
public class question_table {
    private String question_number;
    private String chapter_number;
    private Integer question_type;
    private String question_title;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private Integer question_answer;
    private String question_explain;
    private Integer submit_number;
    private Integer wrong_number;
    private String accuracy;
    private String img_url;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Integer getSubmit_number() {
        return submit_number;
    }

    public void setSubmit_number(Integer submit_number) {
        this.submit_number = submit_number;
    }

    public Integer getWrong_number() {
        return wrong_number;
    }

    public void setWrong_number(Integer wrong_number) {
        this.wrong_number = wrong_number;
    }

    public String getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(String question_number) {
        this.question_number = question_number;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public Integer getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(Integer question_type) {
        this.question_type = question_type;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getOption_a() {
        return option_a;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }

    public Integer getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(Integer question_answer) {
        this.question_answer = question_answer;
    }

    public String getQuestion_explain() {
        return question_explain;
    }

    public void setQuestion_explain(String question_explain) {
        this.question_explain = question_explain;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "question_table{" +
                "question_number='" + question_number + '\'' +
                ", chapter_number='" + chapter_number + '\'' +
                ", question_type=" + question_type +
                ", question_title='" + question_title + '\'' +
                ", option_a='" + option_a + '\'' +
                ", option_b='" + option_b + '\'' +
                ", option_c='" + option_c + '\'' +
                ", option_d='" + option_d + '\'' +
                ", question_answer=" + question_answer +
                ", question_explain='" + question_explain + '\'' +
                ", submit_number=" + submit_number +
                ", wrong_number=" + wrong_number +
                ", accuracy='" + accuracy + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}

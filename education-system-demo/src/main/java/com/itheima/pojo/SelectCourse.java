package com.itheima.pojo;

import org.apache.htrace.shaded.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author liweiliang
 * @create 2023-05-25 21:21:51
 * @description
 */
public class SelectCourse {
    private int cno;
    private int sno;
    private int tno;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String sc_update;

    private int grade;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
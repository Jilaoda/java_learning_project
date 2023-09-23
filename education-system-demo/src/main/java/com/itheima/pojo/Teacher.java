package com.itheima.pojo;


import org.apache.htrace.shaded.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author liweiliang
 * @create 2023-05-23 18:03:28
 * @description 老师实体类
 */
public class Teacher {
    private int tno;
    private String tName;
    private int tAge;
    private char tSex;
    private char tNationality;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String entry_time;

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int gettAge() {
        return tAge;
    }

    public void settAge(int tAge) {
        this.tAge = tAge;
    }

    public char gettSex() {
        return tSex;
    }

    public void settSex(char tSex) {
        this.tSex = tSex;
    }

    public char gettNationality() {
        return tNationality;
    }

    public void settNationality(char tNationality) {
        this.tNationality = tNationality;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getEntryTime() {
        return entry_time;
    }

    public void setEntryTime(String   entryTime) {
        this.entry_time = entryTime;
    }
}
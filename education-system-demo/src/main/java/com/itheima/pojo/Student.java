package com.itheima.pojo;


import org.apache.htrace.shaded.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author liweiliang
 * @create 2023-05-22 21:46:20
 * @description 学生实体类
 */
public class Student {
    private int sno;
    private String sName;
    private int sAge;
    private char sSex;
    private char sNationality;
    private String sDept;
    private String sProfession;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String entrance_time;

    private String passWord;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public char getsSex() {
        return sSex;
    }

    public void setsSex(char sSex) {
        this.sSex = sSex;
    }

    public char getsNationality() {
        return sNationality;
    }

    public void setsNationality(char sNationality) {
        this.sNationality = sNationality;
    }

    public String getsDept() {
        return sDept;
    }

    public void setsDept(String sDept) {
        this.sDept = sDept;
    }

    public String getsProfession() {
        return sProfession;
    }

    public void setsProfession(String sProfession) {
        this.sProfession = sProfession;
    }

    public String getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(String entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
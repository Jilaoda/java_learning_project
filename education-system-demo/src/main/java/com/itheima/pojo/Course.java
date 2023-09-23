package com.itheima.pojo;

/**
 * @author liweiliang
 * @create 2023-05-25 17:54:30
 * @description
 */
public class Course {
    private int cno;
    private String cname;
    private String teacher;
    private int ctno;
    private int cstudents;
    private int ccredit;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCstudents() {
        return cstudents;
    }

    public void setCstudents(int cstudents) {
        this.cstudents = cstudents;
    }

    public int getCcredit() {
        return ccredit;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    public int getCtno() {
        return ctno;
    }

    public void setCtno(int ctno) {
        this.ctno = ctno;
    }
}
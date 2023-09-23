package com.itheima.service;

import com.itheima.pojo.Course;
import com.itheima.pojo.Teacher;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-23 18:25:39
 * @description
 */
public interface TeacherService {
    Teacher selectByTnoPassword(String tno,String passWord);
    List<Course> selectedCourseTno(String tno);


}

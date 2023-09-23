package com.itheima.service;

import com.itheima.pojo.Course;
import com.itheima.pojo.SelectCourse;
import com.itheima.pojo.Student;

import java.util.List;


/**
 * @author liweiliang
 * @create 2023-01-31 21:17
 * @description service接口:后续所有关于Brand的service都实现于此接口;其余业务也是如此
 */
public interface StudentService {

    Student selectBySnoPassword(String sno, String passWord);

    List<Course> selectCourseBySno(String sno);

    List<Course> selectedCourse(String sno);

    List<SelectCourse> programSelect(String sno);

    void updateCourseBySnoCno(String sno,String cno,String tno);

    void deleteCourseBySnoCno(String sno, String cno, String tno);
}

package com.itheima.mapper;

import com.itheima.pojo.Course;
import com.itheima.pojo.SelectCourse;
import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author liweiliang
 * @create 2023-05-23 17:06:47
 * @description
 */
public interface StudentMapper {
    Student selectBySnoPassword(@Param("sno") String sno, @Param("passWord") String passWord);

    List<Course> selectCourseBySno(@Param("sno") String sno);

    List<Course> selectedCourse(@Param("sno") String sno);

    List<SelectCourse> programSelect(@Param("sno") String sno);

    void updateCourseBySnoCno(@Param("sno") String sno,@Param("cno") String cno,
                              @Param("tno")String tno);

    void deleteCourseBySnoCno(@Param("sno") String sno, @Param("cno")String cno, @Param("tno")String tno);
}
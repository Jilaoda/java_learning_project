package com.itheima.mapper;


import com.itheima.pojo.Course;
import com.itheima.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author liweiliang
 * @create 2023-05-23 18:03:05
 * @description
 */
public interface TeacherMapper {
    Teacher selectByTnoPassword(@Param("tno") String tno, @Param("passWord") String passWord);

    List<Course> selectedCourse(@Param("tno") String tno);
}
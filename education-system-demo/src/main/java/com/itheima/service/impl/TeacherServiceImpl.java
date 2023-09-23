package com.itheima.service.impl;

import com.itheima.mapper.TeacherMapper;
import com.itheima.pojo.Course;
import com.itheima.pojo.Teacher;
import com.itheima.service.TeacherService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author liweiliang
 * @create 2023-05-23 18:26:11
 * @description
 */
public class TeacherServiceImpl implements TeacherService {
    //0.获取SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public Teacher selectByTnoPassword(String tno,String passWord) {

        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        //3.执行查询所有
        Teacher teacher = mapper.selectByTnoPassword(String.valueOf(tno),passWord);

        return teacher;
    }

    @Override
    public List<Course> selectedCourseTno(String ctno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        //3.执行查询所有
        List<Course> courses = mapper.selectedCourse(ctno);

        return courses;
    }

}
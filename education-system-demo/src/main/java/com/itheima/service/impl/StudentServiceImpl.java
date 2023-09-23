package com.itheima.service.impl;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Course;
import com.itheima.pojo.SelectCourse;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


/**
 * @author liweiliang
 * @create 2023-01-31 21:37
 * @description 实现BrandService接口
 */
public class StudentServiceImpl implements StudentService {

    //0.获取SqlSessionFactory对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * @details: 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.pojo.Brand>
     */
    @Override
    public Student selectBySnoPassword(String sno, String passWord) {

        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        Student student = mapper.selectBySnoPassword(sno, passWord);

        return student;
    }

    @Override
    public List<Course> selectCourseBySno(String sno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        List<Course> courses = mapper.selectCourseBySno(sno);

        return courses;
    }

    @Override
    public List<Course> selectedCourse(String sno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        List<Course> courses = mapper.selectedCourse(sno);

        return courses;
    }

    @Override
    public List<SelectCourse> programSelect(String sno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        List<SelectCourse> selectCourses = mapper.programSelect(sno);

        return selectCourses;
    }

    @Override
    public void updateCourseBySnoCno(String sno, String cno, String tno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        mapper.updateCourseBySnoCno(sno,cno,tno);

        sqlSession.commit();
    }

    @Override
    public void deleteCourseBySnoCno(String sno, String cno, String tno) {
        //1.开启事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.获取代理
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //3.执行查询所有
        mapper.deleteCourseBySnoCno(sno,cno,tno);

        sqlSession.commit();
    }

}

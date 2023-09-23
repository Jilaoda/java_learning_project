package com.itheima.web.student;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Course;
import com.itheima.pojo.SelectCourse;
import com.itheima.pojo.Student;

import com.itheima.pojo.Teacher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itheima.service.StudentService;
import com.itheima.service.TeacherService;
import com.itheima.service.impl.StudentServiceImpl;
import com.itheima.service.impl.TeacherServiceImpl;
import com.itheima.web.BaseServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * @author liweiliang
 * @create 2023-01-31 21:34
 * @description 登录信息请求类
 */
@WebServlet("/system/*")
public class SystemServlet extends BaseServlet {

    private TeacherService teacherService = new TeacherServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    /***
     * @details: 查询账号密码,用于学生登录判断
     * @param: [request, response]
     * @return: void
     */
    public void selectBySnoPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        //获取请求头的用户名和密码
        String sno = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service查询
        Student student = studentService.selectBySnoPassword(sno,password);

        //判断是否查询出了结果
        if (student == null) {
            // 如果没有查询出结果
            response.getWriter().write("  ");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(student);

            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }

    /**
     * @details: 查询学生用户用于登录后对个人信息的查询
     * @date: 2023/5/25
     * @Param: [request, response]
     * @return: void
     */
    public void selectBySnoPasswordFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        //获取请求头的用户名和密码
        String sno = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service查询
        Student student = studentService.selectBySnoPassword(sno,password);

        //判断是否查询出了结果
        if (student == null) {
            // 如果没有查询出结果
            response.getWriter().write("  ");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(student);

            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }

    /**
     * @details: 查询账号密码,用于老师登录判断
     * @date: 2023/5/25
     * @Param: [request, response]
     * @return: void
     */
    public void selectByTnoPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        //获取请求头的用户名和密码
        String tno = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service查询
        Teacher teacher = teacherService.selectByTnoPassword(tno,password);

        //转为JSON
        String jsonString = JSON.toJSONString(teacher);

        //写数据
        response.setContentType("application/json;charset=utf-8");

        response.getWriter().write(jsonString);
    }


    /**
     * @details: 查询老师用户用于登录后对个人信息的查询
     * @date: 2023/5/25
     * @Param: [request, response]
     * @return: void
     */
    public void selectByTnoPasswordFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        //获取请求头的用户名和密码
        String sno = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service查询
        Teacher teacher = teacherService.selectByTnoPassword(sno,password);

        //判断是否查询出了结果
        if (teacher == null) {
            // 如果没有查询出结果
            response.getWriter().write("  ");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(teacher);

            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }

    public void selectCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String sno = request.getParameter("username");
        List<Course> courses = studentService.selectCourseBySno(sno);
        //判断是否查询出了结果
        if (courses == null) {
            // 如果没有查询出结果
            response.getWriter().write("你已经选满了课哦");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(courses);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void selectedCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String sno = request.getParameter("username");

        List<Course> courses = studentService.selectedCourse(sno);

        if (courses == null) {
            // 如果没有查询出结果
            response.getWriter().write("你没有选课捏!");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(courses);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void programSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String sno = request.getParameter("username");

        List<SelectCourse> courses = studentService.programSelect(sno);

        if (courses == null) {
            // 如果没有查询出结果
            response.getWriter().write("你没有选课捏!");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(courses);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void selectedCourseTno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String tno = request.getParameter("username");

            List<Course> courses = teacherService.selectedCourseTno(tno);

        if (courses == null) {
            // 如果没有查询出结果
            response.getWriter().write("你没有选课捏!");
        } else {
            //如果查询出了结果转为JSON
            String jsonString = JSON.toJSONString(courses);
            //写数据
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }
    }

    public void updateCourseByCno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String sno = request.getParameter("username");
        String cno = request.getParameter("cno");
        String tno = request.getParameter("tno");

        studentService.updateCourseBySnoCno(sno,cno,tno);
    }

    public void deleteCourseByCno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从request中获取request,并执行selectCourseBySno方法,封装json数据传送到前端

        String allowedOrigin = "*";
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");

        String sno = request.getParameter("username");
        String cno = request.getParameter("cno");
        String tno = request.getParameter("tno");

        studentService.deleteCourseBySnoCno(sno,cno,tno);
    }

}

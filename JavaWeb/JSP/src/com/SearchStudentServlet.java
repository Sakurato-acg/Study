package com;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.pojo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        //发sql查询学生的信息
        //使用for循环
        List<Student> studentList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t=i+1;
            studentList.add(new Student(t,"name"+t,18+t,"phone"+t));
        }
        //保存查到的结果(学生信息)到request中
        request.setAttribute("list",studentList);
        //请求转发到jsp页面中
        request.getRequestDispatcher("/showStudent.jsp").forward(request,response);
    }

}

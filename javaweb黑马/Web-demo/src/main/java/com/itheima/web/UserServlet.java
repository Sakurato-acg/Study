package com.itheima.web;


import com.itheima.Mapper.UserMapper;
import com.itheima.Utils.UtilsMapper;
import com.itheima.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@SuppressWarnings("all")
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        SqlSession sqlSession = UtilsMapper.sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User login = mapper.login(username, password);
        sqlSession.close();


        response.setCharacterEncoding("gbk");
        if (login == null) {
            response.getWriter().write("失败");
        } else {
            response.getWriter().write("登陆成功");
        }

//        request.getRequestDispatcher(request.getHeader("Referer")).forward(request,response);
    }


    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        SqlSession sqlSession = UtilsMapper.sqlSessionFactory.openSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);

        User check = mapper.checkUsername(username);

        if (check == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            mapper.register(user);
            UtilsMapper.commitAndClose(sqlSession);
        }else {
            response.setCharacterEncoding("gbk");
            response.getWriter().write("已存在");
        }

    }
}

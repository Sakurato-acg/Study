package com.atguigu.web;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@SuppressWarnings("all")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 处理登陆业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理登陆业务");
        //1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login = userService.login(new User(null, username, password, null));

        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);
        //2.检查用户名是否可用
        if (login != null) {
            //已存在
            request.getSession().setAttribute("user", login);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            request.setAttribute("err", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }

    }

    /**
     * 处理注册业务
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理注册业务");

        //  1、获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());


        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.check(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                // 把回显信息，保存到Request域中
                request.setAttribute("msg", "用户名已存在！！");
                request.setAttribute("username", username);
                request.setAttribute("email", email);

//        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userService.register(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            // 把回显信息，保存到Request域中
            request.setAttribute("msg", "验证码错误！！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);

            System.out.println("验证码[" + code + "]错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

    }


    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数username
        String username = req.getParameter("username");
        // 调用userService.existsUsername();
        boolean existsUsername = userService.check(username);
        // 把返回的结果封装成为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }
}

package com.itzlk.web;

import com.itzlk.pojo.User;
import com.itzlk.service.UserService;
import com.itzlk.service.impl.UserServiceImpl;
import com.itzlk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        //调用Mybatis完成查询
        //获取SqlSession对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User select = mapper.select(username, password);
//        sqlSession.close();


        User user = userService.select(username,password);
//        req.setAttribute("user",user);
//        //设置响应
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();

        if(user!=null){
            //writer.write("登陆成功");
//            req.getRequestDispatcher("/selectAllServlet").forward(req,resp);

            String remember = req.getParameter("remember");


            if("1".equals(remember)){
                //勾选remember将用户信息存入cookie
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //设置存活时间
                c_username.setMaxAge(60*60*24);
                c_password.setMaxAge(60*60*24);

                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }


            //将用户信息存储到服务器session对象中
            HttpSession session = req.getSession();
            session.setAttribute("user",user);


//            System.out.println(contextPath);  ///tomcatDemo2
            resp.sendRedirect("/tomcatDemo2/brand.html");


//            String contextPath = req.getContextPath();
//            resp.sendRedirect(contextPath+"/selectAllServlet");


        }else {
//            writer.write("登陆失败");
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

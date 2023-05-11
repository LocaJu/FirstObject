package com.itzlk.web;

import com.itzlk.pojo.User;
import com.itzlk.service.UserService;
import com.itzlk.service.impl.UserServiceImpl;
import com.itzlk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //封装User
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用Mybatis完成查询
        //获取SqlSession对象
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User u = mapper.selectByUsername(username);
        UserService userService=new UserServiceImpl();
        User u = userService.selectByUsername(username);


        //获取用户输入的验证码
        String checkCode = req.getParameter("checkCode");

        //程序生成的验证码
        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCode");

        //比对验证码   验证码不匹配，跳出，回到注册页面，并给出提示信息
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            req.setAttribute("register_msg","验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);

            //跳出，不允许注册
            return;
        }


//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();

        //用户名已在数据库表中存在，跳出，回到注册页面，并给出提示信息
        if(u!=null){
//            //writer.write("<!DOCTYPE html>");
//            writer.write("<html>");
//            writer.write("<body>");
//            writer.write("<script>");
//            writer.write("alert('用户名已存在')");
//            writer.write("</script>");
//            writer.write("</body>");
//            writer.write("</html>");
            req.setAttribute("register_msg","用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);

        }else {

//            合法用户名，将用户名存入，跳出，回到登录页面，并给出提示信息
            req.setAttribute("register_msg","注册成功请登录");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
//            mapper.add(user);
            userService.add(user);
//            //提交事务
//            sqlSession.commit();
//            sqlSession.close();
//            writer.write("注册成功");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

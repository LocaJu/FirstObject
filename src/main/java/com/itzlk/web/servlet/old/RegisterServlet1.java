package com.itzlk.web.servlet.old;

import com.itzlk.pojo.User;
import com.itzlk.service.UserService;
import com.itzlk.service.impl.UserServiceImpl;
import com.itzlk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet1")
public class RegisterServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求,校验用户名是否存在
        String username=req.getParameter("username");

        UserService userService=new UserServiceImpl();
        User user = userService.selectByUsername(username);


        resp.setContentType("text/html;charset=utf-8");


        boolean flag;
        if(user!=null){
           flag=true;
        }else {
            flag=false;
        }
        PrintWriter writer = resp.getWriter();
        writer.write(""+flag);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

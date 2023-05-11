package com.itzlk.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String[] urls={"login.jsp","/imgs/","/css/","/loginServlet","register.jsp","/registerServlet","/checkCodeServlet"};

        String url = req.getRequestURL().toString();
        System.out.println(url);
        for (String u : urls) {
            if (url.contains(u)) {
                filterChain.doFilter(servletRequest, servletResponse);

                return;
            }
        }

        //判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            //登陆过了，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //没有登录
            req.setAttribute("login_msg","请先登录");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}

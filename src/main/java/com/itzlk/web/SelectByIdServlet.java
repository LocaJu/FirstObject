package com.itzlk.web;

import com.itzlk.pojo.Brand;
import com.itzlk.service.BrandService;
import com.itzlk.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//获取编辑
@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService=new BrandServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收id
        String id=request.getParameter("id");

        Brand brand = brandService.selectById(Integer.parseInt(id));




        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/updateBrand.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

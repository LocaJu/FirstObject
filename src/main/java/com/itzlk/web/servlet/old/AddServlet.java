package com.itzlk.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itzlk.pojo.Brand;
import com.itzlk.service.BrandService;
import com.itzlk.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    BrandService brandService=new BrandServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("utf-8");
//
//        String brandName = request.getParameter("brandName");
//        String companyName = request.getParameter("companyName");
//        String ordered = request.getParameter("ordered");
//        String description = request.getParameter("description");
//        String status = request.getParameter("status");
//
//        Brand brand = new Brand();
//        brand.setBrandName (brandName);
//        brand.setCompanyName(companyName);
//        brand.setOrdered(Integer.parseInt(ordered));
//        brand.setDescription(description);
//        brand.setStatus(Integer.parseInt(status));

        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //System.out.println(params);
        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);





        brandService.add(brand);

        //request.getRequestDispatcher("/selectAllServlet").forward(request,response);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

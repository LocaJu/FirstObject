package com.itzlk.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itzlk.pojo.Brand;
import com.itzlk.pojo.PageBean;
import com.itzlk.service.BrandService;
import com.itzlk.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    BrandService brandService=new BrandServiceImpl();

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串


        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据   序列化
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();
        String id = reader.readLine();

        brandService.deleteById(Integer.parseInt(id));
        response.getWriter().write("success");
    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String id = reader.readLine();

        Brand brand = brandService.selectById(Integer.parseInt(id));

        String jsonString = JSON.toJSONString(brand);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);


    }

    public void upData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串


        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.update(brand);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");

    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 接收品牌数据
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串


        //转为int[]
        int[] ids = JSON.parseObject(params, int[].class);


        brandService.deleteByIds(ids);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 分页查询数据
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);



        String jsonString = JSON.toJSONString(pageBean);



        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);


    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 分页查询数据
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //查询条件的获取
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串


        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);



        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);


        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);


    }

}

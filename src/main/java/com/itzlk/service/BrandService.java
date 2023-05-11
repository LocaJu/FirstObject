package com.itzlk.service;

import com.itzlk.mapper.BrandMapper;
import com.itzlk.pojo.Brand;
import com.itzlk.pojo.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();


    void add(Brand brand);


    Brand selectById(int id);


    void update(Brand brand);


    void deleteById(int id);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
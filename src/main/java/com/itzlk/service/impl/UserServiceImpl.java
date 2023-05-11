package com.itzlk.service.impl;

import com.itzlk.mapper.BrandMapper;
import com.itzlk.mapper.UserMapper;
import com.itzlk.pojo.Brand;
import com.itzlk.pojo.User;
import com.itzlk.service.UserService;
import com.itzlk.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();


    public User select(String username,String password){


        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username,password);

        sqlSession.close();
        return user;
    }

    public User selectByUsername(String username){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUsername(username);

        sqlSession.commit();
        sqlSession.close();
        return user;
    }

    public void add(User user){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
